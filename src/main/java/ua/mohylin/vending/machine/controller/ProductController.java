package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.mohylin.vending.machine.api.ProductService;
import ua.mohylin.vending.machine.dto.NewProductDto;
import ua.mohylin.vending.machine.dto.ProductDto;
import ua.mohylin.vending.machine.mapping.ProductMapper;
import ua.mohylin.vending.machine.model.Product;

@RestController
@RequestMapping("product")
public class ProductController {

  @Autowired private ProductService productService;

  @Autowired private ProductMapper productMapper;

  @Operation(summary = "Retrieve all products")
  @GetMapping
  public List<ProductDto> getAllProducts() {
    return productService.getAllProducts().stream()
        .map(productMapper::productToDto)
        .sorted(Comparator.comparing(ProductDto::getId))
        .collect(Collectors.toUnmodifiableList());
  }

  @Operation(summary = "Add a new product")
  @PostMapping
  public ProductDto createProduct(@RequestBody @Valid NewProductDto productDto) {
    Product product = productMapper.dtoToProduct(productDto);
    Product productWithId = productService.createProduct(product);
    return productMapper.productToDto(productWithId);
  }

  @Operation(summary = "Update an existing product")
  @PutMapping("{productId}")
  public void updateProduct(
      @PathVariable @NotNull Integer productId, @RequestBody @Valid NewProductDto productDto) {
    Product product = productMapper.dtoToProduct(productDto);
    product.setId(productId);
    productService.updateProduct(product);
  }

  @Operation(summary = "Retrieve a product")
  @GetMapping("{productId}")
  public ProductDto getProduct(@PathVariable @NotNull Integer productId) {
    Product product = productService.getProduct(productId);
    return productMapper.productToDto(product);
  }

  @Operation(summary = "Delete a product")
  @DeleteMapping("{productId}")
  public void deleteProduct(@PathVariable @NotNull Integer productId) {
    productService.deleteProduct(productId);
  }
}

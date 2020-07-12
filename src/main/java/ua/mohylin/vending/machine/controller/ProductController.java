package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.mohylin.vending.machine.api.ProductService;
import ua.mohylin.vending.machine.dto.NewProductDto;
import ua.mohylin.vending.machine.dto.ProductDto;
import ua.mohylin.vending.machine.mapping.ProductMapper;
import ua.mohylin.vending.machine.model.Product;

/**
 * CRUD controller for products
 *
 * @author Oleksii Mohylin
 */
@RestController
@RequestMapping("product")
public class ProductController {

  @Autowired private ProductService productService;

  @Autowired private ProductMapper productMapper;

  @Operation(summary = "Retrieve all products")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
            })
      })
  @GetMapping
  public List<ProductDto> getAllProducts() {
    return productService.getAllProducts().stream()
        .map(productMapper::productToDto)
        .sorted(Comparator.comparing(ProductDto::getId))
        .collect(Collectors.toUnmodifiableList());
  }

  @Operation(summary = "Add a new product")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "Product created",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ProductDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid data supplied",
            content = @Content)
      })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDto createProduct(@RequestBody @Valid NewProductDto productDto) {
    Product product = productMapper.dtoToProduct(productDto);
    Product productWithId = productService.createProduct(product);
    return productMapper.productToDto(productWithId);
  }

  @Operation(summary = "Update an existing product")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Product updated"),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid input supplied or product cannot be updated"),
        @ApiResponse(responseCode = "404", description = "Product is not found")
      })
  @PutMapping("{productId}")
  public void updateProduct(
      @PathVariable @NotNull Integer productId, @RequestBody @Valid NewProductDto productDto) {
    Product product = productMapper.dtoToProduct(productDto);
    product.setId(productId);
    productService.updateProduct(product);
  }

  @Operation(summary = "Retrieve a product")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product is found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ProductDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid productId supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
      })
  @GetMapping("{productId}")
  public ProductDto getProduct(@PathVariable @NotNull Integer productId) {
    Product product = productService.getProduct(productId);
    return productMapper.productToDto(product);
  }

  @Operation(summary = "Delete a product")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Product deleted"),
        @ApiResponse(responseCode = "400", description = "Invalid productId supplied"),
        @ApiResponse(responseCode = "404", description = "Product not found")
      })
  @DeleteMapping("{productId}")
  public void deleteProduct(@PathVariable @NotNull Integer productId) {
    productService.deleteProduct(productId);
  }
}

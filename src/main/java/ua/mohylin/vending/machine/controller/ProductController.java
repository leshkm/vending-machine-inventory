package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import ua.mohylin.vending.machine.dto.NewProductDto;
import ua.mohylin.vending.machine.dto.ProductDto;

@RestController
@RequestMapping("product")
public class ProductController {

  @Operation(summary = "Add a new product")
  @PostMapping
  public ProductDto createProduct(@RequestBody @Valid NewProductDto productDto) {
    return null;
  }

  @Operation(summary = "Update an existing product")
  @PutMapping
  public void updateProduct(@RequestBody @Valid NewProductDto productDto) {
    return;
  }

  @Operation(summary = "Retrieve a product")
  @GetMapping
  public ProductDto getProduct(@RequestParam @NotNull Integer productId) {
    return null;
  }

  @Operation(summary = "Delete a product")
  @DeleteMapping
  public void deleteProduct(@RequestParam @NotNull Integer productId) {
    return;
  }
}

package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mohylin.vending.machine.api.ProductService;
import ua.mohylin.vending.machine.api.ProductStorageService;
import ua.mohylin.vending.machine.dto.command.ReleaseProductCommand;
import ua.mohylin.vending.machine.exception.VendingMachineException;
import ua.mohylin.vending.machine.model.Product;

/**
 * Handles commands from clients, i.e. for checking if product is available or releasing it
 *
 * @author Oleksii Mohylin
 */
@RestController
@RequestMapping("command")
public class ClientCommandController {

  @Autowired private ProductService productService;

  @Autowired private ProductStorageService productStorageService;

  @Operation(summary = "Release an item of a product")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Product released"),
        @ApiResponse(responseCode = "400", description = "Invalid input or productId supplied")
      })
  @PostMapping("release-product")
  public void releaseProduct(@RequestBody @Valid ReleaseProductCommand command)
      throws VendingMachineException {

    Product product = productService.getProduct(command.getProductId());

    productStorageService.releaseProduct(product, 1);
  }
}

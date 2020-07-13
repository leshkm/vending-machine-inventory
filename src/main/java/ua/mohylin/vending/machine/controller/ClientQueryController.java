package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
import ua.mohylin.vending.machine.dto.query.CheckProductAvailabilityQuery;
import ua.mohylin.vending.machine.dto.query.CheckProductAvailabilityResponse;
import ua.mohylin.vending.machine.model.Product;

/**
 * Handles commands from clients, i.e. for checking if product is available or releasing it
 *
 * @author Oleksii Mohylin
 */
@RestController
@RequestMapping("command")
public class ClientQueryController {

  @Autowired private ProductService productService;

  @Autowired private ProductStorageService productStorageService;

  @Operation(summary = "Check availability of a product")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = CheckProductAvailabilityResponse.class))
            }),
        @ApiResponse(responseCode = "400", description = "Invalid input supplied")
      })
  @PostMapping("check-product-availability")
  public CheckProductAvailabilityResponse checkProductIsAvailable(
      @RequestBody @Valid CheckProductAvailabilityQuery command) {

    Product product = productService.getProduct(command.getProductId());

    int count = productStorageService.getAvailableProductItems(product);

    return new CheckProductAvailabilityResponse(product.getId(), count);
  }
}

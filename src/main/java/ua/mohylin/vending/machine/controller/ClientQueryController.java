package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mohylin.vending.machine.dto.query.CheckProductAvailabilityQuery;
import ua.mohylin.vending.machine.dto.query.CheckProductAvailabilityResponse;

/** Handles commands from clients, i.e. for checking if product is available or releasing it */
@RestController
@RequestMapping("command")
public class ClientQueryController {

  @Operation(summary = "Check availability of a product")
  @PostMapping("check-product-availability")
  public CheckProductAvailabilityResponse checkProductIsAvailable(
      CheckProductAvailabilityQuery command) {
    return null;
  }
}

package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mohylin.vending.machine.dto.command.ReleaseProductCommand;

/** Handles commands from clients, i.e. for checking if product is available or releasing it */
@RestController
@RequestMapping("command")
public class ClientCommandController {

  @Operation(summary = "Release an item of a product")
  @PostMapping("release-product")
  public void releaseProduct(ReleaseProductCommand command) {
    return;
  }
}

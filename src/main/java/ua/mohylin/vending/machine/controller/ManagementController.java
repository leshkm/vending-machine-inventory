package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ua.mohylin.vending.machine.dto.RowStateDto;
import ua.mohylin.vending.machine.model.RowOccupancy;

@RestController
@RequestMapping("inventory/shelf/{shelfNum}/row/{rowNum}")
public class ManagementController {

  @Operation(summary = "Get information about row occupancy")
  @GetMapping
  public RowOccupancy getRowState(@PathVariable Integer shelfNum, @PathVariable Integer rowNum) {
    return null;
  }

  @Operation(summary = "Update occupancy information for a row")
  @PutMapping
  public void updateRowState(
      @PathVariable Integer shelfNum,
      @PathVariable Integer rowNum,
      @RequestBody @Valid RowStateDto state) {
    return;
  }
}

package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.mohylin.vending.machine.api.OccupancyService;
import ua.mohylin.vending.machine.api.ProductService;
import ua.mohylin.vending.machine.dto.RowOccupancyDto;
import ua.mohylin.vending.machine.dto.RowOccupancyDtoImpl;
import ua.mohylin.vending.machine.dto.RowStateDto;
import ua.mohylin.vending.machine.model.RowOccupancy;

/**
 * Manipulations with storage places (i.e. get state is particular row and update it)
 *
 * @author Oleksii Mohylin
 */
@RestController
@RequestMapping("inventory/shelf/{shelfNum}/row/{rowNum}")
public class ManagementController {

  @Autowired private OccupancyService occupancyService;

  @Autowired private ProductService productService;

  @Operation(summary = "Get information about row occupancy")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = RowOccupancyDto.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "Invalid shelfNum or rowNum supplied",
            content = @Content)
      })
  @GetMapping
  public RowOccupancyDto getRowState(@PathVariable Integer shelfNum, @PathVariable Integer rowNum) {
    RowOccupancy occupancy = occupancyService.getOccupancy(shelfNum, rowNum);
    var builder =
        RowOccupancyDtoImpl.builder()
            .shelfNumber(occupancy.getShelfNumber())
            .rowNumber(occupancy.getRowNumber())
            .productId(occupancy.getProductId())
            .count(occupancy.getCount());
    if (occupancy.getProductId() != null) {
      var product = productService.getProduct(occupancy.getProductId());
      builder.productName(product.getName());
    }
    return builder.build();
  }

  @Operation(summary = "Update occupancy information for a row")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid data supplied",
            content = @Content)
      })
  @PutMapping
  public void updateRowState(
      @PathVariable Integer shelfNum,
      @PathVariable Integer rowNum,
      @RequestBody @Valid RowStateDto state) {

    var occupancy =
        RowOccupancy.builder()
            .rowNumber(rowNum)
            .shelfNumber(shelfNum)
            .productId(state.getProductId())
            .count(state.getCount())
            .build();

    occupancyService.updateOccupancy(occupancy);
  }
}

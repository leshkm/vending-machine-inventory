package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mohylin.vending.machine.dto.report.ProductAvailabilityRecord;
import ua.mohylin.vending.machine.dto.report.ShelvesOccupancyReport;
import ua.mohylin.vending.machine.dto.report.ShelvesOccupancyReportImpl;

@RestController
@RequestMapping("report")
public class ReportsController {

  @Operation(summary = "Products count report")
  @GetMapping("products-count")
  public List<ProductAvailabilityRecord> getProductsCount() {
    return null;
  }

  @Operation(summary = "Shelves occupancy report")
  @GetMapping("shelves-occupancy")
  public ShelvesOccupancyReport getShelvesOccupancyReport() {
    return ShelvesOccupancyReportImpl.builder().build();
  }
}

package ua.mohylin.vending.machine.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mohylin.vending.machine.api.ProductService;
import ua.mohylin.vending.machine.api.ProductStorageService;
import ua.mohylin.vending.machine.dto.report.ProductAvailabilityRecord;
import ua.mohylin.vending.machine.dto.report.ShelvesOccupancyReport;
import ua.mohylin.vending.machine.dto.report.ShelvesOccupancyReportImpl;
import ua.mohylin.vending.machine.model.Product;
import ua.mohylin.vending.machine.model.ProductItemsCount;
import ua.mohylin.vending.machine.repository.RowOccupancyRepository;

@RestController
@RequestMapping("report")
public class ReportsController {

  @Autowired private ProductStorageService productStorageService;

  @Autowired private ProductService productService;

  @Autowired private RowOccupancyRepository occupancyRepository;

  @Operation(summary = "Products count report")
  @GetMapping("products-count")
  public List<ProductAvailabilityRecord> getProductsCount() {
    Collection<ProductItemsCount> availableProducts = occupancyRepository.getProductItemsCount();
    Map<Integer, ProductItemsCount> availableProductsMap =
        availableProducts.stream()
            .map((record) -> Map.entry(record.getProductId(), record))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    final List<Product> allProducts = productService.getAllProducts();
    final Map<Integer, String> allProductNames =
        allProducts.stream()
            .map((product) -> Map.entry(product.getId(), product.getName()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    List<ProductAvailabilityRecord> productAvailabilityReport =
        allProducts.stream()
            .map(
                (product) ->
                    Optional.ofNullable(availableProductsMap.get(product.getId()))
                        .orElseGet(() -> new ProductItemsCount(product.getId(), 0L)))
            .map(
                (productItemsCount) ->
                    new ProductAvailabilityRecord(
                        productItemsCount.getProductId(),
                        allProductNames.get(productItemsCount.getProductId()),
                        productItemsCount.getCount()))
            .sorted(Comparator.comparing(ProductAvailabilityRecord::getId))
            .collect(Collectors.toUnmodifiableList());
    return productAvailabilityReport;
  }

  @Operation(summary = "Shelves occupancy report")
  @GetMapping("shelves-occupancy")
  public ShelvesOccupancyReport getShelvesOccupancyReport() {
    return ShelvesOccupancyReportImpl.builder().build();
  }
}

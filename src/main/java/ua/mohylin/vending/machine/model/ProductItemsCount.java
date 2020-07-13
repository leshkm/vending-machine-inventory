package ua.mohylin.vending.machine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductItemsCount {

  private Integer productId;

  private Long count;
}

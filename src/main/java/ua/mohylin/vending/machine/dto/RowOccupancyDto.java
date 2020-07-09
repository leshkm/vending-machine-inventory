package ua.mohylin.vending.machine.dto;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
public interface RowOccupancyDto {

  int getShelfNumber();

  int getRowNumber();

  @Nullable
  Integer getProductId();

  @Nullable
  String getProductName();

  @Nullable
  Integer getCount();
}

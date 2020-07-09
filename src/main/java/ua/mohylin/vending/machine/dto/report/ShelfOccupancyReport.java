package ua.mohylin.vending.machine.dto.report;

import org.immutables.value.Value;

@Value.Immutable
public interface ShelfOccupancyReport {

  int getShelfNumber();

  int getOccupancyPercent();

  RowOccupancyReport[] getRows();
}

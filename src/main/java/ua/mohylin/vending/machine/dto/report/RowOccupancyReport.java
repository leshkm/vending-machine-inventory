package ua.mohylin.vending.machine.dto.report;

import org.immutables.value.Value;

@Value.Immutable
public interface RowOccupancyReport {

  int getRowNumber();

  int getOccupancyPercent();
}

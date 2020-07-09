package ua.mohylin.vending.machine.dto.report;

import org.immutables.value.Value;

@Value.Immutable
public interface ShelvesOccupancyReport {

  int getOccupancyPercent();

  ShelfOccupancyReport[] getShelves();
}

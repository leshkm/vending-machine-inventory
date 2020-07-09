package ua.mohylin.vending.machine.api;

import ua.mohylin.vending.machine.model.RowOccupancy;

public interface OccupancyService {

  RowOccupancy getOccupancy(int shelfNum, int rowNum);

  void updateOccupancy(RowOccupancy record);
}

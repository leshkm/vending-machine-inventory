package ua.mohylin.vending.machine.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mohylin.vending.machine.api.OccupancyService;
import ua.mohylin.vending.machine.model.RowOccupancy;
import ua.mohylin.vending.machine.model.RowOccupancyId;
import ua.mohylin.vending.machine.repository.RowOccupancyRepository;

@Service
public class OccupancyServiceImpl implements OccupancyService {

  @Autowired private RowOccupancyRepository occupancyRepository;

  @Override
  public RowOccupancy getOccupancy(int shelfNum, int rowNum) {
    RowOccupancyId rowOccupancyId =
        RowOccupancyId.builder().rowNumber(rowNum).shelfNumber(shelfNum).build();
    return occupancyRepository
        .findById(rowOccupancyId)
        .orElseGet(() -> RowOccupancy.builder().rowNumber(rowNum).shelfNumber(shelfNum).build());
  }

  @Override
  public void updateOccupancy(@Valid RowOccupancy record) {
    occupancyRepository.save(record);
  }
}

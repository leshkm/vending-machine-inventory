package ua.mohylin.vending.machine.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mohylin.vending.machine.api.ProductStorageService;
import ua.mohylin.vending.machine.exception.InsufficientProductCapacityException;
import ua.mohylin.vending.machine.model.Product;
import ua.mohylin.vending.machine.model.RowOccupancy;
import ua.mohylin.vending.machine.repository.RowOccupancyRepository;

@Service
public class ProductStorageServiceImpl implements ProductStorageService {

  @Autowired private RowOccupancyRepository occupancyRepository;

  @Override
  public int getAvailableProductItems(Product product) {
    return occupancyRepository.getProductItemsCount(product.getId()).orElse(0);
  }

  @Override
  @Transactional
  public boolean releaseProduct(Product product, int amount)
      throws InsufficientProductCapacityException {

    int productId = product.getId();
    int availableProductItems = getAvailableProductItems(product);
    if (availableProductItems < amount) {
      throw new InsufficientProductCapacityException(productId, availableProductItems, amount);
    }

    int countToBeReleased = amount;
    while (countToBeReleased > 0) {
      RowOccupancy occupancy =
          occupancyRepository.findFirstByProductIdOrderByShelfNumberAscRowNumberAsc(
              product.getId());
      int countToRelease = occupancy.getCount() >= amount ? amount : occupancy.getCount();
      countToBeReleased -= countToRelease;
      occupancy.setCount(occupancy.getCount() - countToRelease);
      if (occupancy.getCount() > 0) {
        occupancyRepository.save(occupancy);
      } else {
        occupancyRepository.delete(occupancy);
      }
    }
    return true;
  }
}

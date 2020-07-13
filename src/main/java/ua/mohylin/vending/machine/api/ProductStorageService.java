package ua.mohylin.vending.machine.api;

import ua.mohylin.vending.machine.exception.VendingMachineException;
import ua.mohylin.vending.machine.model.Product;

public interface ProductStorageService {

  int getAvailableProductItems(Product product);

  boolean releaseProduct(Product product, int amount) throws VendingMachineException;
}

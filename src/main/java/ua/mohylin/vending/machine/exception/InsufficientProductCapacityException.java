package ua.mohylin.vending.machine.exception;

public class InsufficientProductCapacityException extends VendingMachineException {

  public InsufficientProductCapacityException(int productId, int capacity, int requested) {
    super(
        String.format(
            "Product %d: requested items %d, actually available %d",
            productId, requested, capacity));
  }
}

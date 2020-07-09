package ua.mohylin.vending.machine.api;

import java.util.List;
import ua.mohylin.vending.machine.model.Product;

public interface ProductService {

  Product createProduct(Product product);

  void updateProduct(Product product);

  Product getProduct(Integer id);

  void deleteProduct(Integer id);

  List<Product> getAllProducts();
}

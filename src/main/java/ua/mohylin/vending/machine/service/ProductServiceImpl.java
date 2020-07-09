package ua.mohylin.vending.machine.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mohylin.vending.machine.api.ProductService;
import ua.mohylin.vending.machine.model.Product;
import ua.mohylin.vending.machine.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository repository;

  @Override
  public Product createProduct(Product product) {
    return repository.save(product);
  }

  @Override
  public void updateProduct(Product product) {
    repository.save(product);
  }

  @Override
  public Product getProduct(Integer id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public void deleteProduct(Integer id) {
    repository.deleteById(id);
  }

  @Override
  public List<Product> getAllProducts() {
    return repository.findAll();
  }
}

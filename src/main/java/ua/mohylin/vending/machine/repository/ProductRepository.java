package ua.mohylin.vending.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.mohylin.vending.machine.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}

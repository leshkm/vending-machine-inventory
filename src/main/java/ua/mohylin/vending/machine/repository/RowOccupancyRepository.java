package ua.mohylin.vending.machine.repository;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.mohylin.vending.machine.model.ProductItemsCount;
import ua.mohylin.vending.machine.model.RowOccupancy;
import ua.mohylin.vending.machine.model.RowOccupancyId;

@Repository
public interface RowOccupancyRepository extends JpaRepository<RowOccupancy, RowOccupancyId> {

  @Query(
      value =
          "SELECT SUM(r.count) FROM RowOccupancy r WHERE r.productId = :productId GROUP BY r.productId")
  Optional<Integer> getProductItemsCount(int productId);

  @Query(
      value =
          "SELECT new ua.mohylin.vending.machine.model.ProductItemsCount(r.productId, SUM(r.count)) FROM RowOccupancy r GROUP BY r.productId")
  Collection<ProductItemsCount> getProductItemsCount();

  RowOccupancy findFirstByProductIdOrderByShelfNumberAscRowNumberAsc(int productId);
}

package ua.mohylin.vending.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.mohylin.vending.machine.model.RowOccupancy;
import ua.mohylin.vending.machine.model.RowOccupancyId;

@Repository
public interface RowOccupancyRepository extends JpaRepository<RowOccupancy, RowOccupancyId> {}

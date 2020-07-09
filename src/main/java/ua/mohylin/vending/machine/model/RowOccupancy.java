package ua.mohylin.vending.machine.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(RowOccupancyId.class)
public class RowOccupancy {

  @Id private int shelfNumber;

  @Id private int rowNumber;

  private int productId;

  private int count;
}

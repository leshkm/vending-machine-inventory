package ua.mohylin.vending.machine.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RowOccupancy implements Serializable {

  @Id private int shelfNumber;

  @Id private int rowNumber;

  private int productId;

  private int count;
}

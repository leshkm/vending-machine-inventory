package ua.mohylin.vending.machine.model;

import java.io.Serializable;
import javax.persistence.Id;
import lombok.Data;

@Data
public class RowOccupancyId implements Serializable {

  @Id private int shelfNumber;

  @Id private int rowNumber;
}

package ua.mohylin.vending.machine.model;

import java.io.Serializable;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RowOccupancyId implements Serializable {

  @Id private int shelfNumber;

  @Id private int rowNumber;
}

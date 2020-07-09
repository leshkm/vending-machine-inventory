package ua.mohylin.vending.machine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(RowOccupancyId.class)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class RowOccupancy {

  @Id private int shelfNumber;

  @Id private int rowNumber;

  private Integer productId;

  private Integer count;
}

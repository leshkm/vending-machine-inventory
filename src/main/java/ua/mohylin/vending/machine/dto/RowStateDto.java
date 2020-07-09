package ua.mohylin.vending.machine.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RowStateDto {

  @NotNull private Integer productId;

  @NotNull private Integer count;
}

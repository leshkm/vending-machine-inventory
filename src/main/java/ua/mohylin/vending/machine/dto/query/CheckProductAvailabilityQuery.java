package ua.mohylin.vending.machine.dto.query;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckProductAvailabilityQuery {

  @NotNull private Integer productId;
}

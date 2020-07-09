package ua.mohylin.vending.machine.dto.query;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckProductAvailabilityResponse {

  @NotNull private Integer productId;

  @NotNull private Boolean available;

  @NotNull private Integer count;
}

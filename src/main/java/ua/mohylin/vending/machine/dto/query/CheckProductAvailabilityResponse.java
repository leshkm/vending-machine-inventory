package ua.mohylin.vending.machine.dto.query;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckProductAvailabilityResponse {

  @NotNull private Integer productId;

  @NotNull private Integer count;

  public boolean getAvailable() {
    return count > 0;
  }
}

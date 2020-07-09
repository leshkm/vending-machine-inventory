package ua.mohylin.vending.machine.dto.report;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ProductAvailabilityRecord {

  @NotNull private Integer id;

  @Nullable private String name;

  @NotNull private Integer count;
}

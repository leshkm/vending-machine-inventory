package ua.mohylin.vending.machine.dto.command;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReleaseProductCommand {

  @NotNull private Integer productId;
}

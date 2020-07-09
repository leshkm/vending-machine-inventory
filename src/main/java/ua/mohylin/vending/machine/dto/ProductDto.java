package ua.mohylin.vending.machine.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductDto {

  @NotNull private Integer id;

  @NotEmpty private String name;

  @NotNull
  @Range(min = 1, max = 3)
  private Integer size;
}

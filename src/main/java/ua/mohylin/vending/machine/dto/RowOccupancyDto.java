package ua.mohylin.vending.machine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface RowOccupancyDto {

  int getShelfNumber();

  int getRowNumber();

  @Nullable
  Integer getProductId();

  @Nullable
  String getProductName();

  @Nullable
  Integer getCount();

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  default boolean isEmpty() {
    return Objects.isNull(getProductId()) || Objects.isNull(getCount()) || getCount() == 0;
  }
}

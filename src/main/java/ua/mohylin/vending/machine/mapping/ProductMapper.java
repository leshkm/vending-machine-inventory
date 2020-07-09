package ua.mohylin.vending.machine.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.mohylin.vending.machine.dto.NewProductDto;
import ua.mohylin.vending.machine.dto.ProductDto;
import ua.mohylin.vending.machine.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(target = "id", ignore = true)
  Product dtoToProduct(NewProductDto dto);

  ProductDto productToDto(Product product);
}

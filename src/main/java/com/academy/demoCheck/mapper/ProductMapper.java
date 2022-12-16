package com.academy.demoCheck.mapper;

import com.academy.demoCheck.model.dto.ProductDto;
import com.academy.demoCheck.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : Volha Salash
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDTO(Product product);

    Product toModel(ProductDto dto);

    List<Product> toModelList(List<ProductDto> dtos);

    List<ProductDto> toDTOList(List<Product> models);
}

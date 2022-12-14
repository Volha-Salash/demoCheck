package com.academy.demoCheck.mapper.interfaces;

import com.academy.demoCheck.dto.ProductDto;
import com.academy.demoCheck.model.entity.Product;

import java.util.List;
import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface ProductMapper {

    Set<ProductDto> toDtoList(Set<Product> products);

    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}

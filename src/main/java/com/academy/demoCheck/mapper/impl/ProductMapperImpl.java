package com.academy.demoCheck.mapper.impl;

import com.academy.demoCheck.dto.ProductDto;
import com.academy.demoCheck.mapper.interfaces.ProductMapper;
import com.academy.demoCheck.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Set<ProductDto> toDtoList(Set<Product> products) {
        if (products == null) {
            return null;
        }

        Set<ProductDto> set = new HashSet<>(products.size());
        for (Product productEntity : products) {
            set.add(toDto(productEntity));
        }

        return set;
    }

    @Override
    public ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setSale(product.getSale());

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        Product productEntity = new Product();

        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setSale(productDto.getSale());

        return productEntity;
    }
}

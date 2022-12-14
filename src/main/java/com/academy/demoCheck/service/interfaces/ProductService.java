package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.dto.ProductDto;

import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface ProductService {

    ProductDto getProduct(Integer id);

    Set<ProductDto> getAllProducts();

    void addProduct(ProductDto productDto);

}
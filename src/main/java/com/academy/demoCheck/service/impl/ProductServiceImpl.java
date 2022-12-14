package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.dto.ProductDto;
import com.academy.demoCheck.mapper.interfaces.ProductMapper;
import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.model.repository.interfaces.ProductRepository;
import com.academy.demoCheck.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : Volha Salash
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    @Override
    public ProductDto getProduct(Integer id) {
        return productMapper.toDto(productRepository.getProductById(id));
    }

    @Override
    public Set<ProductDto> getAllProducts() {
        return productMapper.toDtoList(productRepository.getProducts());
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product.setId(product.getId());
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setSale(product.getSale());
        productRepository.addProduct(product);
        log.info("Created new product " + product.getName());
    }

}


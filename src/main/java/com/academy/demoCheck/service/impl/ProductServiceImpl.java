package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.exception.ProductNotFoundException;
import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.model.repository.ProductRepository;
import com.academy.demoCheck.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Volha Salash
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        Product product = productRepository.getReferenceById(id);

        if (product == null) {
            throw new ProductNotFoundException();
        }

        return product;
    }
}

package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.repository.impl.ProductRepositoryImpl;

/**
 * @author : Volha Salash
 */
public interface ProductReaderService {
    void read(ProductRepositoryImpl productRepository);
}

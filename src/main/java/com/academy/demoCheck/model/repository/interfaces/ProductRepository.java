package com.academy.demoCheck.model.repository.interfaces;

import com.academy.demoCheck.model.entity.Product;

import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface ProductRepository {

    Set<Product> getProducts();

    Product getProductById(Integer id);

    void addProduct(Product product);
}

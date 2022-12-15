package com.academy.demoCheck.model.repository.impl;

import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.model.repository.interfaces.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Set<Product> products = new HashSet<>();

    @Override
    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        for (Product product : products) {
            if (id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Integer id, String name, Double price, int sale) {
        Product product = new Product(id, name, price, sale);
        product.setId(product.getId());
        products.add(product);
    }

}

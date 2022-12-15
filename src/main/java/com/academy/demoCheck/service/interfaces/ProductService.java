package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.entity.Product;

import java.util.List;

/**
 * @author : Volha Salash
 */
public interface ProductService {

    List<Product> findAll();

    Product getById(Integer id);
}

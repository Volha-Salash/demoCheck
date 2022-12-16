package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author : Volha Salash
 */
public interface ProductService {

    List<Product> findAll();

    Optional<Product> getById(Integer id);
}

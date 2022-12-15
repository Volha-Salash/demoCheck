package com.academy.demoCheck.model.repository;

import com.academy.demoCheck.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Volha Salash
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

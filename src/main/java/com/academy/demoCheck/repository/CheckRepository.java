package com.academy.demoCheck.repository;

import com.academy.demoCheck.model.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Volha Salash
 */
@Repository
public interface CheckRepository extends JpaRepository<Check, Integer> {

    List<Check> findAll();
}
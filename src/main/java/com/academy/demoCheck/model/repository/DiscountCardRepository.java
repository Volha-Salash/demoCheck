package com.academy.demoCheck.model.repository;

import com.academy.demoCheck.model.entity.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Volha Salash
 */
@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Integer> {

}

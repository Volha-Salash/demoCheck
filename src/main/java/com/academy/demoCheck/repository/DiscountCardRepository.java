package com.academy.demoCheck.repository;

import com.academy.demoCheck.model.entity.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : Volha Salash
 */
@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Integer> {

    DiscountCard findByNumber(Integer number);
}

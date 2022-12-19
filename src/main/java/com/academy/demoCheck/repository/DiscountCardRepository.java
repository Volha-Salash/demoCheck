package com.academy.demoCheck.repository;

import com.academy.demoCheck.model.entity.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Volha Salash
 */
@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Integer> {

    Optional<DiscountCard> findByNumber(Integer number);
}

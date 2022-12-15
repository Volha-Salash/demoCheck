package com.academy.demoCheck.model.repository.interfaces;

import com.academy.demoCheck.model.entity.DiscountCard;

/**
 * @author : Volha Salash
 */
public interface DiscountCardRepository {

    DiscountCard getDiscountCardsByNumber(Integer number);

    void addDiscountCard(Integer id, Integer number, Integer discount);
}

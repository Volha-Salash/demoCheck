package com.academy.demoCheck.model.repository.interfaces;

import com.academy.demoCheck.model.entity.DiscountCard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface DiscountCardRepository {

    Set<DiscountCard> getDiscountCards();

    DiscountCard getDiscountCardsByNumber(Integer number);

    void addDiscountCard(Integer id, Integer number, Integer discount);
}

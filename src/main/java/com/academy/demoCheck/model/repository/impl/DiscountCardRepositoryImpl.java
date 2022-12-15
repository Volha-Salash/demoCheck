package com.academy.demoCheck.model.repository.impl;

import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.repository.interfaces.DiscountCardRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Volha Salash
 */
@Repository
public class DiscountCardRepositoryImpl implements DiscountCardRepository {

    private final List<DiscountCard> discountCards = new ArrayList<>();

    @Override
    public void addDiscountCard(Integer id, Integer number, Integer discount) {
        DiscountCard discountCard = new DiscountCard(id, number, discount);
        discountCards.add(discountCard);
    }

    @Override
    public DiscountCard getDiscountCardsByNumber(Integer number) {
        for (DiscountCard discountCard : discountCards) {
            if (number.equals(discountCard.getNumber())) {
                return discountCard;
            }
        }
        return null;
    }
}

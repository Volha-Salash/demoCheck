package com.academy.demoCheck.model.repository.impl;

import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.repository.interfaces.DiscountCardRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
@Repository
public class DiscountCardRepositoryImpl implements DiscountCardRepository {

    private final Set<DiscountCard> discountCards = new HashSet<>();

    @Override
    public Set<DiscountCard> getDiscountCards() {
        return discountCards;
    }

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

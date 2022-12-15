package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.repository.DiscountCardRepository;
import com.academy.demoCheck.service.interfaces.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Volha Salash
 */
@Service
@RequiredArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardService {

    private final List<DiscountCard> listOfCards = new ArrayList<>();
    private final DiscountCardRepository repository;

    @Override
    public List<DiscountCard> findAll() {
        return repository.findAll();
    }

    @Override
    public DiscountCard getByNumber(Integer number) {
        for (DiscountCard discountCard : listOfCards) {
            if (number.equals(discountCard.getNumber())) {
                return discountCard;
            }
        }
        return null;
    }
}

package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.exception.ProductNotFoundException;
import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.model.repository.DiscountCardRepository;
import com.academy.demoCheck.service.interfaces.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Volha Salash
 */
@Service
@RequiredArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardService {

    private final DiscountCardRepository repository;

    @Override
    public List<DiscountCard> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DiscountCard> findByNumber(String number) {
        return repository.findByNumber(number);
    }
}
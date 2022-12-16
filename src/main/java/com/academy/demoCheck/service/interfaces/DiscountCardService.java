package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.entity.DiscountCard;

import java.util.List;

/**
 * @author : Volha Salash
 */
public interface DiscountCardService {

    List<DiscountCard> findAll();

    List<DiscountCard> findByNumber(String number);
}

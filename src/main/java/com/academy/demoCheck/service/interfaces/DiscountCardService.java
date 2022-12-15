package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.entity.DiscountCard;

import java.util.List;

/**
 * @author : Volha Salash
 */
public interface DiscountCardService {

    List<DiscountCard> findAll();

    DiscountCard getByNumber(Integer number);

}

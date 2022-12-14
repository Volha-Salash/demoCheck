package com.academy.demoCheck.mapper.interfaces;

import com.academy.demoCheck.dto.DiscountCardDto;
import com.academy.demoCheck.model.entity.DiscountCard;

import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface DiscountCardMapper {

    Set<DiscountCardDto> toDtoList(Set<DiscountCard> discountCards);

    DiscountCardDto toDto(DiscountCard discountCard);

    DiscountCard toEntity(DiscountCardDto discountCardDto);
}

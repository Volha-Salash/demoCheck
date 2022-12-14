package com.academy.demoCheck.mapper.impl;

import com.academy.demoCheck.dto.DiscountCardDto;
import com.academy.demoCheck.mapper.interfaces.DiscountCardMapper;
import com.academy.demoCheck.model.entity.DiscountCard;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
@Component
public class DiscountCardMapperImpl implements DiscountCardMapper {

    @Override
    public Set<DiscountCardDto> toDtoList(Set<DiscountCard> discountCards) {
        if (discountCards == null) {
            return null;
        }

        Set<DiscountCardDto> set = new HashSet<>(discountCards.size());
        for (DiscountCard discountCardEntity : discountCards) {
            set.add(toDto(discountCardEntity));
        }

        return set;
    }

    @Override
    public DiscountCardDto toDto(DiscountCard discountCard) {
        if (discountCard == null) {
            return null;
        }

        DiscountCardDto discountCardDto = new DiscountCardDto();

        discountCardDto.setId(discountCard.getId());
        discountCardDto.setNumber(discountCard.getNumber());
        discountCardDto.setDiscount(discountCard.getDiscount());

        return discountCardDto;
    }

    @Override
    public DiscountCard toEntity(DiscountCardDto discountCardDto) {
        if (discountCardDto == null) {
            return null;
        }

        DiscountCard discountCardEntity = new DiscountCard();

        discountCardEntity.setId(discountCardDto.getId());
        discountCardEntity.setNumber(discountCardDto.getNumber());
        discountCardEntity.setDiscount(discountCardDto.getDiscount());

        return discountCardEntity;
    }
}

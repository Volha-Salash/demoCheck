package com.academy.demoCheck.mapper;

import com.academy.demoCheck.model.dto.DiscountCardDto;
import com.academy.demoCheck.model.entity.DiscountCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : Volha Salash
 */
@Mapper(componentModel = "spring")
public interface DiscountCardMapper {

    DiscountCardMapper INSTANCE = Mappers.getMapper(DiscountCardMapper.class);

    DiscountCardDto toDTO(DiscountCard model);

    DiscountCard toModel(DiscountCardDto dto);

    List<DiscountCard> toModelList(List<DiscountCardDto> dtos);

    List<DiscountCardDto> toDTOList(List<DiscountCard> models);
}
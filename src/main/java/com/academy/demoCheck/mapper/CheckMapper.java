package com.academy.demoCheck.mapper;

import com.academy.demoCheck.model.dto.CheckDto;
import com.academy.demoCheck.model.entity.Check;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : Volha Salash
 */
@Mapper(componentModel = "spring")
public interface CheckMapper {

    CheckMapper INSTANCE = Mappers.getMapper(CheckMapper.class);

    CheckDto toDTO(Check model);

    Check toModel(CheckDto dto);
}
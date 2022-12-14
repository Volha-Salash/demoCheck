package com.academy.demoCheck.mapper.interfaces;

import com.academy.demoCheck.dto.CheckDto;
import com.academy.demoCheck.model.entity.Check;

import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface CheckMapper {

    Set<CheckDto> toDtoList(Set<Check> checks);

    CheckDto toDto(Check check);

    Check toEntity(CheckDto checkDto);
}

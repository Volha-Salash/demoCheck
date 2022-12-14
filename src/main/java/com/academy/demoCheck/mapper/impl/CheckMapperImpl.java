package com.academy.demoCheck.mapper.impl;

import com.academy.demoCheck.dto.CheckDto;
import com.academy.demoCheck.mapper.interfaces.CheckMapper;
import com.academy.demoCheck.model.entity.Check;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
@Component
public class CheckMapperImpl implements CheckMapper {

    @Override
    public Set<CheckDto> toDtoList(Set<Check> checks) {
        if (checks == null) {
            return null;
        }

        Set<CheckDto> set = new HashSet<>(checks.size());
        for (Check checkEntity : checks) {
            set.add(toDto(checkEntity));
        }

        return set;
    }

    @Override
    public CheckDto toDto(Check check) {
        if (check == null) {
            return null;
        }

        CheckDto checkDto = new CheckDto();

        checkDto.setId(check.getId());
        checkDto.setAmount(check.getAmount());

        return checkDto;
    }

    @Override
    public Check toEntity(CheckDto checkDto) {
        if (checkDto == null) {
            return null;
        }

        Check checkEntity = new Check();

        checkEntity.setId(checkDto.getId());
        checkEntity.setAmount(checkDto.getAmount());

        return checkEntity;
    }
}

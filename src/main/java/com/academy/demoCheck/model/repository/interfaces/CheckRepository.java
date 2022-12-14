package com.academy.demoCheck.model.repository.interfaces;

import com.academy.demoCheck.model.entity.Check;

import java.util.Set;

/**
 * @author : Volha Salash
 */
public interface CheckRepository {

    void createCheck(Integer id, Integer amount);

    Set<Check> getChecks();
}
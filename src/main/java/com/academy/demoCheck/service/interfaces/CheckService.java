package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.entity.Check;

import java.util.List;

/**
 * @author : Volha Salash
 */
public interface CheckService {
    List<Check> findAllChecks();
}

package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.entity.Check;
import com.academy.demoCheck.repository.CheckRepository;
import com.academy.demoCheck.service.interfaces.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Volha Salash
 */
@Service
@RequiredArgsConstructor
public class CheckServiceImpl  implements CheckService {

    private  final CheckRepository checkRepository;

    @Override
    public List<Check> findAllChecks() {
        return checkRepository.findAll();
    }
}

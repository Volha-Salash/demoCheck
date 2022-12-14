package com.academy.demoCheck.model.repository.impl;

import com.academy.demoCheck.model.entity.Check;
import com.academy.demoCheck.model.repository.interfaces.CheckRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Volha Salash
 */
@Repository
public class CheckRepositoryImpl implements CheckRepository {

    private final Set<Check> checks = new HashSet<>();

    @Override
    public void createCheck(Integer id, Integer amount) {
        Check check = new Check(id, amount);
        checks.add(check);
    }

    @Override
    public Set<Check> getChecks() {
        return checks;
    }
}

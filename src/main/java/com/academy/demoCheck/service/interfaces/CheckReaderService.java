package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.repository.impl.CheckRepositoryImpl;

/**
 * @author : Volha Salash
 */
public interface CheckReaderService {

    void read(CheckRepositoryImpl checkRepository);
}

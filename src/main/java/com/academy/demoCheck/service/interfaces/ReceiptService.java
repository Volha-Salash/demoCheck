package com.academy.demoCheck.service.interfaces;

import com.academy.demoCheck.model.dto.console.CheckConsoleDto;
import com.academy.demoCheck.model.entity.Receipt;

/**
 * @author : Volha Salash
 */
public interface ReceiptService {
    Receipt createReceipt(CheckConsoleDto checkDto);
}

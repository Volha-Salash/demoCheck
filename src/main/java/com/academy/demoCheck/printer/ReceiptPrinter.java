package com.academy.demoCheck.printer;

import com.academy.demoCheck.model.dto.console.CheckConsoleDto;

/**
 * @author : Volha Salash
 */
public interface ReceiptPrinter {
    void print(CheckConsoleDto checkDto);
}

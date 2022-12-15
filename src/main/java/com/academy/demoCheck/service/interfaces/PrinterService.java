package com.academy.demoCheck.service.interfaces;

import java.io.PrintWriter;

/**
 * @author : Volha Salash
 */
public interface PrinterService {

    void printCheck(Integer number);

    Double findProduct(PrintWriter pw);

    void discount(Integer discount, Double totalSum, PrintWriter pw);

    int saleProduct();
}

package com.academy.demoCheck.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author : Volha Salash
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReceiptProduct {

    private Product product;

    private int amount;

    private BigDecimal totalSum;

    private BigDecimal discountSum;

    private BigDecimal totalSumWithDiscount;

}

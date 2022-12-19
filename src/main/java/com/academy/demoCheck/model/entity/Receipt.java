package com.academy.demoCheck.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author : Volha Salash
 */
@Getter
@Setter
@NoArgsConstructor
public class Receipt implements Serializable {

    private List<ReceiptProduct> products;

    private DiscountCard discountCard;

    private LocalDate date;

    private LocalTime time;

    private BigDecimal totalSum;

    private BigDecimal discountSum;

    private BigDecimal totalSumWithDiscount;

}

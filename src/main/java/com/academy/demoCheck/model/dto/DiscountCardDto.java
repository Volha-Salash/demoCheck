package com.academy.demoCheck.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : Volha Salash
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCardDto implements Serializable {

    private Long id;

    private Integer number;

    private BigDecimal discount;

}

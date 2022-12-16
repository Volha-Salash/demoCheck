package com.academy.demoCheck.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Volha Salash
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCardDto implements Serializable {

    private Integer id;

    private String number;

    private Integer discount;

}

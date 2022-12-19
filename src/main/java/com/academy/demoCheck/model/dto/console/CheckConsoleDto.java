package com.academy.demoCheck.model.dto.console;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Volha Salash
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckConsoleDto implements Serializable {

    private List<ProductConsoleDto> products;

    private Integer discountCardNumber;
}

package com.academy.demoCheck.model.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : Volha Salash
 */
@Entity
@Data
@Table(name = "discount_card")
@NoArgsConstructor
public class DiscountCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    @NotNull
    private Integer number;

    @Column(name = "discount")
    private BigDecimal discount;

    public DiscountCard(Long id, Integer number, BigDecimal discount) {
    }
}

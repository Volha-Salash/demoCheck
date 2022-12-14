package com.academy.demoCheck.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
    private Integer number;

    @Column(name = "discount")
    private Integer discount;

    public DiscountCard(Integer id, Integer number, Integer discount) {
    }
}

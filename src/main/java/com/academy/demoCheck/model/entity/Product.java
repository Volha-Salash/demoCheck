package com.academy.demoCheck.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

import static java.sql.Types.NUMERIC;

/**
 * @author : Volha Salash
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price",
            columnDefinition = "NUMERIC(19,0)"
    )
    private Double price;

    @Column(name = "sale")
    private int sale;
}

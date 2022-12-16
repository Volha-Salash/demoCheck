package com.academy.demoCheck.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Volha Salash
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="checks")
public class Check implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

}

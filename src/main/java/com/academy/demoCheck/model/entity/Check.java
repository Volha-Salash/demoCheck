package com.academy.demoCheck.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Volha Salash
 */

@Data
@NoArgsConstructor
public class Check implements Serializable {

    private Integer id;

    private Integer amount;

    public Check(Integer id, Integer amount) {
    }
}

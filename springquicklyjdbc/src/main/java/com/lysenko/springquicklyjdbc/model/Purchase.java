package com.lysenko.springquicklyjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    private int id;
    private String name;
    private BigDecimal price;

    public Purchase(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}

package com.lysenko.shoppingcart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500)
    private String title;
    @Column(length = 5000)
    private String description;
    private String category;
    private BigDecimal price;
    private int stock;
    private String image;
    private int discount;
    private BigDecimal discountPrice;
    private Boolean isActive;
}

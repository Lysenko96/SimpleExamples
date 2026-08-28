package com.lysenko.shoppingcart.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private UserCustom user;
    @ManyToOne
    private Product product;
    private BigDecimal quantity;
    @Transient
    private BigDecimal totalPrice;
    @Transient
    private BigDecimal totalOrderPrice;
}

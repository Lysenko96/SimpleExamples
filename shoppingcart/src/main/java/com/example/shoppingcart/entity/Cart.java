package com.example.shoppingcart.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Cart extends Product {

    private Integer quantity;

    private Double totalPrice;

    public Cart(Long id, String name, String category, Double price, String image, Integer quantity, Double totalPrice) {
        super(id, name, category, price, image);
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }



}

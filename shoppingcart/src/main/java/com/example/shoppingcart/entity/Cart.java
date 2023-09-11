package com.example.shoppingcart.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Cart extends Product{

    private Integer quantity;

    public Cart(Long id, String name, String category, String price, String image, Integer quantity) {
        super(id, name, category, price, image);
        this.quantity = quantity;
    }
}

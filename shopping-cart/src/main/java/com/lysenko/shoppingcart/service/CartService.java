package com.lysenko.shoppingcart.service;

import com.lysenko.shoppingcart.model.Cart;

import java.util.List;

public interface CartService {

    Cart saveCart(Integer productId, Integer userId);

    List<Cart> getCartsByUserId(Integer userId);
}

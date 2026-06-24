package com.lysenko.shoppingcart.repository;

import com.lysenko.shoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByProductIdAndUserId(Integer productId, Integer userId);
}

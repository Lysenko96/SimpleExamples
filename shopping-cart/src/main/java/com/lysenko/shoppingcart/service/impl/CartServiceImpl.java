package com.lysenko.shoppingcart.service.impl;

import com.lysenko.shoppingcart.model.Cart;
import com.lysenko.shoppingcart.model.Product;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.repository.CartRepository;
import com.lysenko.shoppingcart.repository.ProductRepository;
import com.lysenko.shoppingcart.repository.UserRepository;
import com.lysenko.shoppingcart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Cart saveCart(Integer productId, Integer userId) {
        UserCustom userCustom = userRepository.findById(userId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        if (userCustom == null || product == null) {
           log.info("saveCart userCustom or product is null");
           log.info("userCustom: {}", userCustom);
           log.info("product: {}", product);
           return null;
        }
        Cart cartStatus = cartRepository.findByProductIdAndUserId(productId, userId);
        Cart cart = null;
        if (ObjectUtils.isEmpty(cartStatus)) {
            cart = new Cart();
            cart.setProduct(product);
            cart.setUser(userCustom);
            cart.setQuantity(BigDecimal.ONE);
            cart.setTotalPrice(product.getDiscountPrice());
        } else {
            cart = cartStatus;
            cart.setQuantity(cart.getQuantity().add(BigDecimal.ONE));
            cart.setTotalPrice(cart.getQuantity().multiply(cart.getProduct().getDiscountPrice()));
        }
        Cart saveCart = cartRepository.save(cart);
        log.info("saveCart cart: {}", saveCart);
        return saveCart;
    }

    @Override
    public List<Cart> getCartsByUserId(Integer userId) {
        return List.of();
    }
}

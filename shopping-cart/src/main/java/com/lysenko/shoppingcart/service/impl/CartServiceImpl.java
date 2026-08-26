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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
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
        List<Cart> carts = cartRepository.findByUserId(userId);
        List<Cart> updateCarts = new ArrayList<>();
        BigDecimal totalOrderPrice = BigDecimal.ZERO;
        for (Cart cart : carts) {
            BigDecimal totalPrice = cart.getProduct().getDiscountPrice().multiply(cart.getQuantity());
            cart.setTotalPrice(totalPrice);
            totalOrderPrice = totalOrderPrice.add(totalPrice);
            cart.setTotalOrderPrice(totalOrderPrice);
            updateCarts.add(cart);
        }
        return carts;
    }

    @Override
    public Integer getCountCart(Integer userId) {
        Integer countByUserId = cartRepository.countByUserId(userId);
        return countByUserId;
    }

    @Override
    public void updateQuantity(String symbol, Integer cid) {
        Cart cart = cartRepository.findById(cid).orElse(null);
        if (cart == null) {
            log.info("Cart is null");
            return;
        }
        BigDecimal updateQty = BigDecimal.ZERO;
        if(symbol.equalsIgnoreCase("minus")) {
            updateQty = cart.getQuantity().subtract(BigDecimal.ONE);
            if (updateQty.compareTo(BigDecimal.ZERO) <= 0) {
                cartRepository.deleteById(cid);
                return;
            }
        } else {
            updateQty = cart.getQuantity().add(BigDecimal.ONE);
        }
        cart.setQuantity(updateQty);
        cartRepository.save(cart);
    }
}

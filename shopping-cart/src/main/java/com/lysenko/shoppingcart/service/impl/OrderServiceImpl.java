package com.lysenko.shoppingcart.service.impl;

import com.lysenko.shoppingcart.model.*;
import com.lysenko.shoppingcart.repository.CartRepository;
import com.lysenko.shoppingcart.repository.ProductOrderRepository;
import com.lysenko.shoppingcart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductOrderRepository productOrderRepository;
    private final CartRepository cartRepository;

    @Override
    public void saveOrder(Integer userId, OrderRequest request) {

        List<Cart> carts = cartRepository.findByUserId(userId);

        for (Cart cart : carts) {
            ProductOrder order = ProductOrder.builder()
                    .orderId(UUID.randomUUID().toString())
                    .orderDate(LocalDateTime.now())
                    .product(cart.getProduct())
                    .price(cart.getProduct().getDiscountPrice())
                    .quantity(cart.getQuantity())
                    .user(cart.getUser())
                    .status(OrderStatus.IN_PROGRESS.getStatus())
                    .paymentType(request.getPaymentType())
                    .orderAddress(OrderAddress.builder()
                            .firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .address(request.getAddress())
                            .state(request.getState())
                            .email(request.getEmail())
                            .city(request.getCity())
                            .mobileNumber(request.getMobileNumber())
                            .pincode(request.getPincode())
                            .build())
                    .build();

            productOrderRepository.save(order);
        }
    }

    @Override
    public List<ProductOrder> getOrdersByUserId(Integer userId) {
        List<ProductOrder> orders = productOrderRepository.findByUserId(userId);
        return orders;
    }

    @Override
    public Boolean updateOrderStatus(Integer id, String status) {
        Optional<ProductOrder> optOrder = productOrderRepository.findById(id);
        if (optOrder.isEmpty()) {
            return false;
        }
        ProductOrder order = optOrder.get();
        order.setStatus(status);
        productOrderRepository.save(order);
        return true;
    }
}

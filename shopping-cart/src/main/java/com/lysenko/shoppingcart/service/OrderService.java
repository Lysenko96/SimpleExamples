package com.lysenko.shoppingcart.service;

import com.lysenko.shoppingcart.model.OrderRequest;
import com.lysenko.shoppingcart.model.ProductOrder;

import java.util.List;

public interface OrderService {

    void saveOrder(Integer userId, OrderRequest orderRequest);

    List<ProductOrder> getOrdersByUserId(Integer userId);

    Boolean updateOrderStatus(Integer id, String status);
}

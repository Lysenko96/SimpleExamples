package com.lysenko.shoppingcart.service;

import com.lysenko.shoppingcart.model.OrderRequest;

public interface OrderService {

    void saveOrder(Integer userId, OrderRequest orderRequest);
}

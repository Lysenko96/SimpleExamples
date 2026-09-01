package com.lysenko.shoppingcart.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum OrderStatus {
    IN_PROGRESS(1, "In Progress"),
    ORDER_RECEIVED(2, "Order received"),
    PRODUCT_PACKED(3, "Product Packed"),
    OUT_FOR_DELIVERY(4, "Out for Delivery"),
    DELEVERED(5, "Delivered"),
    CANCEL(6, "Cancelled");

    private int id;
    private String status;

    OrderStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }
}

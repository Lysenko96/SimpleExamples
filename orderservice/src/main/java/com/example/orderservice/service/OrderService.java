package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void makeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

//        order.setOrderLineItemList(orderRequest.getOrderLineItemDtoList()
//                .stream()
//                .map(orderLineItemDto -> new OrderLineItem(orderLineItemDto.getId(), orderLineItemDto.getSkuCode(), orderLineItemDto.getPrice(), orderLineItemDto.getQuantity()))
//                .collect(Collectors.toList()));

        orderRepository.save(order);
    }
}

package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private WebClient.Builder webClientBuilder;
    //private WebClient webClient;


    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        //this.webClient = webClient;
        this.webClientBuilder = webClientBuilder;
    }

    public void makeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        order.setOrderLineItemList(orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(orderLineItemDto -> new OrderLineItem(orderLineItemDto.getId(), orderLineItemDto.getSkuCode(), orderLineItemDto.getPrice(), orderLineItemDto.getQuantity()))
                .collect(Collectors.toList()));

        List<String> skuCodes = order.getOrderLineItemList().stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        //Call inventory service and make order if product is in stock
        InventoryResponse[] inventoryResponsesArray = webClientBuilder
                //.baseUrl("http://inventory_service")
                .build().get()
                .uri("http://localhost:8083/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                //.uri("/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block(); // block indicates synch request between product and order

        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponsesArray))
                .allMatch(InventoryResponse::isInStock);

        if(allProductsInStock) orderRepository.save(order);
        else throw new IllegalArgumentException("Product is not in stock");
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}

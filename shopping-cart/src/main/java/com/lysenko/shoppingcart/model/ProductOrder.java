package com.lysenko.shoppingcart.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderId;
    private LocalDate orderDate;
    @ManyToOne
    private Product product;
    private BigDecimal price;
    private BigDecimal quantity;
    @ManyToOne
    private UserCustom user;
    private String status;
    private String paymentType;
    @OneToOne(cascade = CascadeType.ALL)
    private OrderAddress orderAddress;
}

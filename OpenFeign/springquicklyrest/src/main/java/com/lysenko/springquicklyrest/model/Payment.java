package com.lysenko.springquicklyrest.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String id;
    private double amount;
}

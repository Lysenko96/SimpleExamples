package com.example.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "car_identity")
public class CarIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    @ManyToOne
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private CarType carType;
}

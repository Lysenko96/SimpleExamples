package com.example.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "car_sequence")
public class CarSequence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String model;
}

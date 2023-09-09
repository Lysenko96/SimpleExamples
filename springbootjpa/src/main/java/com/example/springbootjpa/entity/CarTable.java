package com.example.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "car_table")
public class CarTable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String model;
}

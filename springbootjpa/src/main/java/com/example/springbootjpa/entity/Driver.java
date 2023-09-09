package com.example.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Transient
    private Address address;

    @OneToMany(mappedBy = "driver")
    private List<CarIdentity> cars;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "driver_categories",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private List<Category> categories;

}

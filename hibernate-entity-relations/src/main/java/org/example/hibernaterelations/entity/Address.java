package org.example.hibernaterelations.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String number;
    private String postCode;
    @ToString.Exclude
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}

package com.example.springmapstruct.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}

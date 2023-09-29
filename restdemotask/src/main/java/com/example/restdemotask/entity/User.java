package com.example.restdemotask.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    public static long id;
    Long uniqueId;
    String email;
    String firstName;
    String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthDate;
    Address address;
    String phone;

    public User() {
        ++id;
        uniqueId = id;
    }

    public User(String email, String firstName, String lastName, LocalDate birthDate) {
        ++id;
        uniqueId = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public User(String email, String firstName, String lastName, LocalDate birthDate, Address address) {
        ++id;
        uniqueId = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public User(String email, String firstName, String lastName, LocalDate birthDate, Address address, String phone) {
        ++id;
        uniqueId = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uniqueId='" + uniqueId + '\'' +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                '}';
    }
}

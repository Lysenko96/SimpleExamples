package org.example.springcourse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    private int year;
    private String phone;
    private String address;
    private String email;

    public Person(String firstName, String secondName, int year, String phone, String address, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.year = year;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}

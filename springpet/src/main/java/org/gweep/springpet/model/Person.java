package org.gweep.springpet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private long id;
    private String firstname;
    private String lastname;
    private int year;
    private String address;
    private String email;
    private int phone;
    private String sex;
    private String role;

    public Person(String firstname, String lastname, int year, String address, String email, int phone, String sex, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.year = year;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.role = role;
    }
}

package org.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private long id;
    private String name;
    private String surname;
    private int year;
    private String login;
    private String password;
    private String email;
    private int phone;

    public Person(String name, String surname, int year, String login, String password, String email, int phone) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}

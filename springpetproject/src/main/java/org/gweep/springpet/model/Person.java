package org.gweep.springpet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private int year;
    private String email;
    private String address;
    private String phone;
    private Role role;
    private List<Task> tasks;

    public Person(String firstname, String lastname, String login, String password, int year, String email, String address, String phone, Role role, List<Task> tasks) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.year = year;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.tasks = tasks;
    }
}

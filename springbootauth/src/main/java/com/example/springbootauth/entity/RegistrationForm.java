package com.example.springbootauth.entity;

import lombok.Data;

import java.util.Collections;
import java.util.Set;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String email;
    private String phone;
//    private Set<Role> roles;

    public User getUser(){
        return new User(username, password, email ,phone//,  Collections.singleton(Role.USER)
        );
    }
}

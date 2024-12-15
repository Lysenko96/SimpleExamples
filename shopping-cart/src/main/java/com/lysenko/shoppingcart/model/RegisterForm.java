package com.lysenko.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {

    private String username;
    private String password;
    private String email;
    private String phone;
    private Set<Role> roles = new HashSet<>();
}

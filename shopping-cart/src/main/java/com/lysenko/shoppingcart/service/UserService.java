package com.lysenko.shoppingcart.service;


import com.lysenko.shoppingcart.model.UserCustom;

public interface UserService {

    UserCustom saveUser(UserCustom userCustom);

    UserCustom getUserByEmail(String email);
}

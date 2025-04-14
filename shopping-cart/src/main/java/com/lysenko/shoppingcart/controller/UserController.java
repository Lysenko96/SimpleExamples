package com.lysenko.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart")
public class UserController {

    @GetMapping("/user")
    public String home() {
        return "user/home";
    }
}

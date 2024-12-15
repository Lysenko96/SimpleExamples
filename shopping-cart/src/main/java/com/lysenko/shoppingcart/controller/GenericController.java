package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.RegisterForm;
import com.lysenko.shoppingcart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart")
public class GenericController {

    private final UserService userService;

    public GenericController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(RegisterForm form) {
        userService.save(form);
        return "redirect:/login";
    }
}


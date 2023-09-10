package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.RegistrationForm;
import com.example.shoppingcart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private String registration(){
        return "registration";
    }

    @PostMapping
    public String processUser(RegistrationForm form){
        userService.save(form.getUser());
        return "redirect:/login";
    }
}

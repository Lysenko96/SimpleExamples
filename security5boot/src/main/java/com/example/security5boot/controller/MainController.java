package com.example.security5boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/authenticated")
    public String authenticated(Principal principal){
        return "authenticated " + principal.getName();
    }
}

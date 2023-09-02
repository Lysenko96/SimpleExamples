package com.example.springbootauth.controller;

import com.example.springbootauth.entity.Role;
import com.example.springbootauth.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model){
        if (user != null) {
            model.addAttribute("user", user.getUsername());
        } else {
            model.addAttribute("user", "anonymous");
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/for_user")
    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    public String forUser(){
        return "for_user";
    }

    @GetMapping("/for_admin")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public String forAdmin(){
        return "for_admin";
    }
}

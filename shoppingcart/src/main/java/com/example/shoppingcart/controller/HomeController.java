package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.User;
import com.example.shoppingcart.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("products", productService.findAll());
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

    @GetMapping("/order")
    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    public String order(){
        return "order";
    }

    @GetMapping("/cart")
    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    public String cart(){
        return "cart";
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

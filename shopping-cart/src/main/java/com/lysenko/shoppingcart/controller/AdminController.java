package com.lysenko.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart/admin")
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/add-product")
    public String adminAddProduct() {
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category() {
        return "admin/category";
    }
}

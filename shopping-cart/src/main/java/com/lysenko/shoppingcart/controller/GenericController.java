package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
public class GenericController {

    private final CategoryService categoryService;
    private final ProductService productService;

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

    @GetMapping("/product")
    public String products(Model model, @RequestParam(value = "category", required = false) String category) {
        System.out.println("Category: " + category);
        model.addAttribute("categories", categoryService.findAllActive());
        model.addAttribute("products", productService.findAllActiveByCategory(category));
        model.addAttribute("paramCategory", category);
        return "product";
    }

    @GetMapping("/product-details/{id}")
    public String product(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product_details";
    }
}


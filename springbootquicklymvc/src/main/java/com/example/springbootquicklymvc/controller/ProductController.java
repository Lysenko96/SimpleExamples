package com.example.springbootquicklymvc.controller;

import com.example.springbootquicklymvc.entity.Product;
import com.example.springbootquicklymvc.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping
//            (produces = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct(
//            @ModelAttribute
            Product product, Model model) {
        productService.addProduct(product);
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products.html";
    }
}

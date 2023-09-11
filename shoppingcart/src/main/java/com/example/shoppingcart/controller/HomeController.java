package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.User;
import com.example.shoppingcart.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = ("/cart/{id}"), method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    public String cart(@PathVariable Long id, Model model, HttpServletRequest request){
        Product product = productService.findById(id);
        String quantityStr = request.getParameter("quantity");
        Integer quantity;
        if (quantityStr == null) quantity = 1;
        else quantity = Integer.parseInt(quantityStr);
        Cart cart = new Cart(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getImage(),quantity);
        model.addAttribute("cart", cart);
        System.out.println(cart.getQuantity());
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

package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.User;
import com.example.shoppingcart.service.CartService;
import com.example.shoppingcart.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    private ProductService productService;
    private CartService cartService;
    private Set<Cart> carts = new HashSet<>();

    public HomeController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
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
        HttpSession session = request.getSession();
        //Set<Cart> cartList = (HashSet<Cart>) session.getAttribute("carts");
        List<Product> products = productService.findAll();
        Product product = productService.findById(id);
        String quantityStr = request.getParameter("quantity");
        int quantity = cartService.calculateQuantity(quantityStr);
        if(quantity == 0) carts = cartService.clearCarts(carts, null, product);
        carts = cartService.saveCarts(carts, new HashSet<>(), product, session, quantity);
        carts = cartService.filterCarts(carts, products);
        model.addAttribute("carts", carts);
        double total = carts.stream().mapToDouble(Cart::getTotalPrice).sum();
        model.addAttribute("total", total);
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

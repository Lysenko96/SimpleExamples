package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Cart;
import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CartService;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;
    private final CartService cartService;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";


    @ModelAttribute
    public void getUserDetails(Principal login, Model model) {
        if (login != null) {
            String email = login.getName();
            UserCustom user = userService.getUserByEmail(email);
            model.addAttribute("user", user);
        }
        List<Category> allActive = categoryService.findAllActive();
        model.addAttribute("categories", allActive);
    }

    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "redirect:/shopping-cart/";
    }

    @GetMapping("/addCart")
    public String addToCart(@RequestParam Integer pid, @RequestParam Integer uid, HttpSession session) {
        Cart saveCart = cartService.saveCart(pid, uid);
        if (ObjectUtils.isEmpty(saveCart)) {
            session.setAttribute(ERROR, "Product add to cart failed");
        } else {
            session.setAttribute(SUCCESS, "Product added to cart");
        }
        return "redirect:/shopping-cart/product-details/" + pid;
    }

}

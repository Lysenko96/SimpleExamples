package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;

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
        return "user/home";
    }
}

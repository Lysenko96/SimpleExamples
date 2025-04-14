package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.ProductService;
import com.lysenko.shoppingcart.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Controller
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
public class GenericController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/main-login")
    public String login() {
        System.out.println("######login");
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

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserCustom userCustom, @RequestParam("img") MultipartFile file,
                           HttpSession session) throws IOException {
        String image = file.isEmpty() ? "default.jpg" : file.getOriginalFilename();
        userCustom.setImage(image);
        UserCustom saveUserCustom = userService.saveUser(userCustom);
        if (ObjectUtils.isEmpty(saveUserCustom)) {
            session.setAttribute("error", "User register failed");
        }
        if (!file.isEmpty()) {
            File saveFile = new ClassPathResource("static/img").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "profile_img" + File.separator + image);
            System.out.println(path);
            Files.copy(Objects.requireNonNull(file.getInputStream()), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("success", "User register successfully");
        }
        return "redirect:/shopping-cart/register";
    }
}


package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.ProductService;
import com.lysenko.shoppingcart.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
@Slf4j
public class GenericController {

    private static final String CATEGORIES = "categories";
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String IMG_PATH = "static/img";
    private static final String PROFILE_IMG = "profile_img";
    private static final String DEFAULT_IMG_NAME = "unknown.jpg";
    private static final String REDIRECT_REGISTER = "redirect:/shopping-cart/register";

    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;

    @ModelAttribute
    public void getUserDetails(Principal login, Model model) {
        if (login != null) {
            String email = login.getName();
            UserCustom user = userService.getUserByEmail(email);
            model.addAttribute("user", user);
        }
        List<Category> allActive = categoryService.findAllActive();
        model.addAttribute(CATEGORIES, allActive);
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/main-login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    @ModelAttribute
    public String logout(Model model) {
        model.addAttribute("user", null);
        return "/shopping-cart/main-login?logout";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/product")
    public String products(Model model, @RequestParam(value = "category", required = false) String category) {
        log.info("Category: {}", category);
        model.addAttribute(CATEGORIES, categoryService.findAllActive());
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
//        String image = file.isEmpty() ? DEFAULT_IMG_NAME : file.getOriginalFilename();
        String image = file != null ? file.getOriginalFilename() : DEFAULT_IMG_NAME;
        userCustom.setImage(image);
        UserCustom saveUserCustom = userService.saveUser(userCustom);
        if (saveUserCustom == null) {
            session.setAttribute(ERROR, "User register failed");
            return REDIRECT_REGISTER;
        }
        File saveFile = new ClassPathResource(IMG_PATH).getFile();
        Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + PROFILE_IMG + File.separator + image);
        log.info("saveUser path: {}", path);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
        session.setAttribute(SUCCESS, "User register successfully");
        return REDIRECT_REGISTER;
    }
}


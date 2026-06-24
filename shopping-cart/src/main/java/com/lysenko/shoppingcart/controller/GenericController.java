package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.ProductService;
import com.lysenko.shoppingcart.service.UserService;
import com.lysenko.shoppingcart.util.CommonUtil;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

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
    private final CommonUtil commonUtil;
    private final PasswordEncoder passwordEncoder;

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

    @RequestMapping(value = "/main-login", method = {RequestMethod.GET, RequestMethod.POST})
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

    @GetMapping("/forgot-password")
    public String showForgotPassword() {
        return "forgot_password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, HttpSession session, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        UserCustom userByEmail = userService.getUserByEmail(email);
        if (ObjectUtils.isEmpty(userByEmail)) {
            session.setAttribute(ERROR, "Invalid email");
        } else {
            String resetToken = UUID.randomUUID().toString();
            userService.updateUserResetToken(email, resetToken);
            String url = commonUtil.generateUrl(request) + "/shopping-cart/reset-password?token=" + resetToken;
            System.out.println("####resetUrl: " + url);
            Boolean sendMail = commonUtil.sendMail(url, email);
            if (sendMail.equals(Boolean.TRUE)) {
                session.setAttribute(SUCCESS, "Please check your email... Password reset link sent");
            } else {
                session.setAttribute(ERROR, "Something wrong on server. Email not send");
            }
        }
        return "redirect:/shopping-cart/forgot-password";
    }

    @GetMapping("/reset-password")
    public String showResetPassword(@RequestParam String token, HttpSession session, Model model) {
        UserCustom userByToken = userService.getUserByToken(token);
        System.out.println("####userByToken: " + userByToken);
        if (ObjectUtils.isEmpty(userByToken)) {
            model.addAttribute(ERROR, "Your link is invalid or expired");
            return "message";
        }
        model.addAttribute("token", token);
        return "reset_password";
    }

    @PostMapping("/reset-password")
    public String processResetPassword(@RequestParam String token, @RequestParam String password, HttpSession session, Model model) {
        UserCustom userByToken = userService.getUserByToken(token);
        System.out.println("####POSTuserByToken: " + userByToken);
        System.out.println("###POSTtoken: " + token);
        if (ObjectUtils.isEmpty(userByToken)) {
            model.addAttribute(ERROR, "Your link is invalid or expired");
            return "message";
        } else {
            userByToken.setPassword(passwordEncoder.encode(password));
            userByToken.setResetToken(null);
            userService.updateUser(userByToken);
            model.addAttribute("token", token);
            model.addAttribute(SUCCESS, "Password change successfully");
            return "message";
        }
    }

}
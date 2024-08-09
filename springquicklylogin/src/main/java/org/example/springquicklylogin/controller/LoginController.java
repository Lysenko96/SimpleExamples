package org.example.springquicklylogin.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springquicklylogin.model.User;
import org.example.springquicklylogin.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@RequestScope
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String loginGet() {
        log.debug(this.toString());
        log.debug(loginService.toString());
        return "login";
    }

    @PostMapping("/")
    public String loginPost(User user, Model model) {
        String message = loginService.validateUser(user);
        model.addAttribute("message", message);
        log.debug(message);
        return "login";
    }
}

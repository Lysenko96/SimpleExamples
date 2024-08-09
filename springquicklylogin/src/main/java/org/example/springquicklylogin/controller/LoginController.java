package org.example.springquicklylogin.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.springquicklylogin.model.User;
import org.example.springquicklylogin.service.LoggedUserManagementService;
import org.example.springquicklylogin.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@RequestScope
public class LoginController {

    private final LoginService loginService;
    private final LoggedUserManagementService loggedUserManagementService;

    public LoginController(LoginService loginService, LoggedUserManagementService loggedUserManagementService) {
        this.loginService = loginService;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/")
    public String loginGet() {
        log.debug(this.toString());
        log.debug(loginService.toString());
        return "login";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().invalidate();
        log.debug(this.toString());
        log.debug(loginService.toString());
        return "logout";
    }

    @GetMapping("/main")
    public String mainGet(Model model) {
        String loggedUsername = loggedUserManagementService.getUsername();
        String message = "login failed";
        model.addAttribute("message", message);
        if(loggedUsername == null) return "login";
        log.debug(this.toString());
        log.debug(loginService.toString());
        return "main";
    }

    @PostMapping("/")
    public String loginPost(User user, Model model) {
        boolean loggedIn = loginService.validateUser(user);
        String loggedUsername = loggedUserManagementService.getUsername();
        String message = "login failed";
        model.addAttribute("message", message);
        log.debug(String.format("%s %s", loginService.getClass().getSimpleName(), loginService));
        log.debug("{} {}", loggedUserManagementService.getClass().getSimpleName(), loggedUserManagementService);
        if(loggedUsername == null) return "login";
        if (loggedIn) {
            model.addAttribute("message", "login successfully");
            return "main";
        }
        return "login";
    }
}

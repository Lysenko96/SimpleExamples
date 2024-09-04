package org.example.springquicklylogin.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.springquicklylogin.model.User;
import org.example.springquicklylogin.service.LoggedUserManagementService;
import org.example.springquicklylogin.service.LoginCountService;
import org.example.springquicklylogin.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public LoginController(LoginService loginService, LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loginService = loginService;
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/")
    public String loginGet(Model model) {
        model.addAttribute("counter", loginCountService.getCount());
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
    public String mainGet(Model model, @RequestParam(required = false) String logout) {

//        if(logout != null) loggedUserManagementService.setUsername(null);

        String loggedUsername = loggedUserManagementService.getUsername();
        String message = "login failed";
        model.addAttribute("message", message);
//        model.addAttribute("counter", loginCountService.getCount());
        if(loggedUsername == null) return "login";
        log.debug(this.toString());
        log.debug(loginService.toString());
        return "main";
    }

    @PostMapping("/")
    public String loginPost(User user, Model model) {
        loginCountService.increment();
        boolean loggedIn = loginService.validateUser(user);
        String loggedUsername = loggedUserManagementService.getUsername();
        String message = "login failed";
        model.addAttribute("message", message);
        model.addAttribute("counter", loginCountService.getCount());
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

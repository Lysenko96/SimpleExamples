package info.gweep.cookiefilter.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("message", "you got cookie!");
        return "index";
    }

    @GetMapping("/cookie")
    public String cookie(HttpServletResponse response){
        response.addCookie(new Cookie("login", "test"));
        return "cookie";
    }
}

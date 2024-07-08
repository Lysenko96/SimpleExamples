package com.example.springbootquicklymvc.controller;

import com.example.springbootquicklymvc.entity.MyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "tony");
        page.addAttribute("age", "28");
        return "home.html";
    }

    @GetMapping("post")
    public ResponseEntity<?> post(@RequestParam String value) {
        System.out.println(Boolean.valueOf(value));
        return ResponseEntity.ok(Boolean.valueOf(value));
    }
}

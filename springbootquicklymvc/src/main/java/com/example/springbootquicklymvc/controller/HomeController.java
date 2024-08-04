package com.example.springbootquicklymvc.controller;

import com.example.springbootquicklymvc.entity.MyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class HomeController {

    @RequestMapping("/home/{id}/{text}")
    public String home(@RequestParam(required = false) String color,
                       @RequestParam("name") String theName,
                       @PathVariable("id") Long myId,
                       @PathVariable String text, Model page) {
        page.addAttribute("id", myId);
        page.addAttribute("text", text);
        page.addAttribute("username", theName);
        page.addAttribute("age", "28");
        page.addAttribute("color", color);
        return "home.html";
    }

    @GetMapping("post")
    public ResponseEntity<?> post(@RequestParam String value) {
        System.out.println(Boolean.valueOf(value));
        return ResponseEntity.ok(Boolean.valueOf(value));
    }
}

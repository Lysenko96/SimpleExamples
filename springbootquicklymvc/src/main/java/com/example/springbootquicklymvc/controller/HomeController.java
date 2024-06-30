package com.example.springbootquicklymvc.controller;

import com.example.springbootquicklymvc.entity.MyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class HomeController {

//    @RequestMapping("/home")
//    public String home() {
//        return "home.html";
//    }

    @GetMapping("post")
    public ResponseEntity<?> post(@RequestParam String value) {
        System.out.println(Boolean.valueOf(value));
        return ResponseEntity.ok(Boolean.valueOf(value));
    }
}

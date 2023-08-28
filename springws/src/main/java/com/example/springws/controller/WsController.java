package com.example.springws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sendMessage")
public class WsController {

    @GetMapping
    public String sendMessage(){
        return "sendMessage";
    }

}

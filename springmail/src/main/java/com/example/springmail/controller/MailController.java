package com.example.springmail.controller;

import com.example.springmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/email")
    public String sendMail(){
        mailService.sendMailMessage("anton.lysenko.info@gmail.com", "subject", "text");
        return "send";
    }
}

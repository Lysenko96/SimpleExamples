package com.example.springmail.controller;

import com.example.springmail.model.Email;
import com.example.springmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/email")
    public String sendMail(@RequestBody Email email){
        mailService.sendMailMessage("anton.lysenko.info@gmail.com", email.getSubject(), email.getText());
        return "send";
    }
}

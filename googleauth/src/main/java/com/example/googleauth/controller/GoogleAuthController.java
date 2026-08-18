package com.example.googleauth.controller;

import com.example.googleauth.dto.UserLoginDto;
import com.example.googleauth.dto.UserRegisterDto;
import com.example.googleauth.entity.UserRegisterData;
import com.example.googleauth.service.GoogleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleAuthController {

    @Autowired
    private GoogleAuthService gAuthService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDto userDto) {
        try {
            UserRegisterData userRegisterData = new UserRegisterData();
            String secretKey = gAuthService.generateKey();
            userRegisterData.setPassword(userDto.getPassword());
            userRegisterData.setUsername(userDto.getUsername());
            userRegisterData.setSecretKey(secretKey);
            gAuthService.addUser(userRegisterData);
            return ResponseEntity.ok("User added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
        String key = gAuthService.getSecretKey(userLoginDto);
        if (key.isEmpty()) {
            return ResponseEntity.ok("No user found");
        }
        boolean isValid = gAuthService.isValid(key, userLoginDto.getCode());
        if (isValid) {
            return ResponseEntity.ok("Log in successfully");
        } else {
            return ResponseEntity.ok("Log in failed");
        }
    }
}

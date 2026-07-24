package com.example.springmapstruct.controller;

import com.example.springmapstruct.dto.ResponseClientDto;
import com.example.springmapstruct.service.UserAppService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAppController {

    @Resource
    private UserAppService userAppService;

    @GetMapping("/add")
    public ResponseEntity<String> addDB() {
        userAppService.addDb();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getResponse")
    public ResponseEntity<ResponseClientDto> getResponse(@RequestParam String name) {
        ResponseClientDto response = userAppService.getResponseUserAppDto(name);
        return ResponseEntity.ok(response);
    }

}

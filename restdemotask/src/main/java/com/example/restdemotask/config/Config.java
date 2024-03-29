package com.example.restdemotask.config;

import com.example.restdemotask.controller.UserController;
import com.example.restdemotask.entity.User;
import com.example.restdemotask.repository.UserRepository;
import com.example.restdemotask.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public User user() {
        return new User();
    }
}

package com.example.restdemotask.config;

import com.example.restdemotask.entity.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public Users user() {
        return new Users();
    }
}

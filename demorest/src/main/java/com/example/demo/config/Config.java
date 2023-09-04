package com.example.demo.config;

import com.example.demo.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Car car(){
        return new Car();
    }
}

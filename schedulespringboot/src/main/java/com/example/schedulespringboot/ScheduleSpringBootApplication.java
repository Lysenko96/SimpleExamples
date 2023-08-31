package com.example.schedulespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ScheduleSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleSpringBootApplication.class, args);
    }

}

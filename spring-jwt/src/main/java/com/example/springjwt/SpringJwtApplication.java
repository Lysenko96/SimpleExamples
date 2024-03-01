package com.example.springjwt;

import com.example.springjwt.dto.RegistrationUserDto;
import com.example.springjwt.entity.Role;
import com.example.springjwt.entity.User;
import com.example.springjwt.repository.RoleRepository;
import com.example.springjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApplication.class, args);
    }

}

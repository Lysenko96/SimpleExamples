package com.example.springjwt;

import com.example.springjwt.dto.RegistrationUserDto;
import com.example.springjwt.entity.Role;
import com.example.springjwt.entity.User;
import com.example.springjwt.repository.RoleRepository;
import com.example.springjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringJwtApplication {

    private UserService userService;
    private RoleRepository roleRepository;


    public SpringJwtApplication(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return args -> {
//            Role admin = roleRepository.save(new Role("ROLE_ADMIN"));
//            Role user = roleRepository.save(new Role("ROLE_USER"));
//            userService.createNewUser(new RegistrationUserDto("admin", "admin","admin", "adm@gmail.com",  List.of(admin)));
//            userService.createNewUser(new RegistrationUserDto("user", "user","user", "usr@gmail.com", List.of(user)));
//        };
//    }

}

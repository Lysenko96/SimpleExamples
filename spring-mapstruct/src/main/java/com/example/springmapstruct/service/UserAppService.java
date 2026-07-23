package com.example.springmapstruct.service;

import com.example.springmapstruct.entity.Address;
import com.example.springmapstruct.entity.Role;
import com.example.springmapstruct.entity.UserApp;
import com.example.springmapstruct.repository.UserAppRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserAppService {

    @Resource
    private UserAppRepository userAppRepository;

    public void addDb() {
        List<UserApp> users = List.of(
                new UserApp(null, "name", 1, "login", "password", new Address("country", "city"), List.of(Role.USER, Role.ADMIN))
        );
        userAppRepository.saveAll(users);
    }
}

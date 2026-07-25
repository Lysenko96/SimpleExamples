package com.example.springmapstruct.service;

import com.example.springmapstruct.dto.ResponseClientDto;
import com.example.springmapstruct.entity.Address;
import com.example.springmapstruct.entity.Role;
import com.example.springmapstruct.entity.UserApp;
import com.example.springmapstruct.entity.UserAppSecond;
import com.example.springmapstruct.mapper.UserAppMapper;
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
    @Resource
    private UserAppMapper userAppMapper;

    public void addDb() {
        List<UserApp> users = List.of(
                new UserApp(null, "name", null, "login", "password", new Address("country", "city"), List.of(Role.USER, Role.ADMIN))
        );
        userAppRepository.saveAll(users);
    }

    public ResponseClientDto getResponseUserAppDto(String name){
        UserApp userApp = userAppRepository.findByName(name);
        System.out.println(userAppMapper.toDemoUserAppDto(userApp));
        return userAppMapper.toResponseClientDto(userApp, new UserAppSecond(44));
    }


}

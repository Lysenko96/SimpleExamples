package com.example.spring.service;

import com.example.spring.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@ToString
@Service
public class UserService {

    private final UserMapper userMapper;
//    private final UserRepositoryClass userRepositoryClass;

}

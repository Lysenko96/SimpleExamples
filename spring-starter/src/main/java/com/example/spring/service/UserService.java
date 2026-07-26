package com.example.spring.service;

import com.example.spring.mapper.UserMapper;
import com.example.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
}

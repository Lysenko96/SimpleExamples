package com.example.spring.service;

import com.example.spring.mapper.UserMapper;
import com.example.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@ToString
@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
}

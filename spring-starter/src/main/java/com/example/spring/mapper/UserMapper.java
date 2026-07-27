package com.example.spring.mapper;

import com.example.spring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@ToString
@Component
public class UserMapper {

    private final UserDto userDto;
}


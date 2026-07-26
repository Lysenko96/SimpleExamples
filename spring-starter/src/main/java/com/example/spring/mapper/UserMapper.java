package com.example.spring.mapper;

import com.example.spring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserMapper {

    private final UserDto userDto;
}

package com.example.spring.mapper;

import com.example.spring.dto.CompanyDto;
import com.example.spring.dto.UserReadDto;
import com.example.spring.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User user) {
        return UserReadDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .birthDate(user.getBirthDate())
                .company(user.getCompany() != null ? companyReadMapper.map(user.getCompany()) : null)
                .role(user.getRole())
                .build();
    }
}

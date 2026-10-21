package com.example.spring.mapper;

import com.example.spring.dto.UserCreateEditDto;
import com.example.spring.model.Company;
import com.example.spring.model.User;
import com.example.spring.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    private final CompanyRepository companyRepository;

    @Override
    public User map(UserCreateEditDto from, User to) {
        return to.toBuilder()
                .username(from.getUsername())
                .firstname(from.getFirstname())
                .lastname(from.getLastname())
                .birthDate(from.getBirthDate())
                .company(getCompanyById(from.getCompanyId()))
                .role(from.getRole())
                .build();
    }

    @Override
    public User map(UserCreateEditDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .birthDate(userDto.getBirthDate())
                .company(getCompanyById(userDto.getCompanyId()))
                .role(userDto.getRole())
                .build();
    }

    private Company getCompanyById(Integer id) {
//        Optional.ofNullable(id).flatMap(companyRepository::findById).orElse(null);
        return id != null ? companyRepository.findById(id).orElse(null) : null;
    }
}

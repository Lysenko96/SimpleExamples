package com.example.spring.mapper;

import com.example.spring.dto.CompanyDto;
import com.example.spring.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyDto> {

    @Override
    public CompanyDto map(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }
}

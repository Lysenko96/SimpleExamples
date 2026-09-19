package com.example.spring.dto;

import lombok.Builder;

@Builder
public record CompanyDto(Integer id, String name) {
}

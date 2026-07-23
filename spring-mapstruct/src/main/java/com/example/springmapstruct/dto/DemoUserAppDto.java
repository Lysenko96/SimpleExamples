package com.example.springmapstruct.dto;

import com.example.springmapstruct.entity.Address;

import java.util.UUID;

public record DemoUserAppDto(
        UUID id,
        String name,
        Integer age,
        String login,
        String password,
        Address address,
        String roles
) {
}
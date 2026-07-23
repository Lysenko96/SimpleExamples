package com.example.springmapstruct.dto;

import com.example.springmapstruct.entity.Address;
import com.example.springmapstruct.entity.Role;

import java.util.List;
import java.util.UUID;


public record UserAppDto(
        UUID id,
        String name,
        Integer age,
        String login,
        String password,
        Address address,
        List<Role> roles) {
}

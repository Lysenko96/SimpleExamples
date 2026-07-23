package com.example.springmapstruct.dto;

import com.example.springmapstruct.entity.Address;
import com.example.springmapstruct.entity.Role;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseClientDto(
        String name,
        Integer age,
        Address address,
        List<Role> roles,
        LocalDateTime response) {
}

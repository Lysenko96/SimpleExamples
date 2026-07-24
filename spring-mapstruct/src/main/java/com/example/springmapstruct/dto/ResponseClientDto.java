package com.example.springmapstruct.dto;

import com.example.springmapstruct.entity.Address;
import com.example.springmapstruct.entity.Role;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseClientDto(
        String clientName,
        Integer clientAge,
        Address clientAddress,
        List<Role> clientRoles,
        LocalDateTime response) {
}

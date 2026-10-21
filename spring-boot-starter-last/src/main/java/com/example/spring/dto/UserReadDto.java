package com.example.spring.dto;

import com.example.spring.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@Value
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReadDto {

    private Long id;
    private String username;
    private LocalDateTime birthDate;
    private String firstname;
    private String lastname;
    private Role role;
    private CompanyDto company;

}

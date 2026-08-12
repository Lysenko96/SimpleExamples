package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

//@Value
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto {

    private Long id;
    private String username;

}

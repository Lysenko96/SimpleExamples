package com.example.spring.dto;

import com.example.spring.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldNameConstants
public class UserCreateEditDto {

    private String username;
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime birthDate;
    private String firstname;
    private String lastname;
    private Role role;
    private Integer companyId;
}

package com.example.springmapstruct.entity;

import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAppSecond {

    private UUID id;
    private String name;
    private Integer age;

    public UserAppSecond(Integer age) {
        this.age = age;
    }
}

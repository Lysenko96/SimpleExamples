package com.example.spring.repository;

import lombok.*;

import java.util.List;
import java.util.Map;

@ToString
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class UserRepository {

    private String name;
    private Integer poolSize;
    private List<Object> objects;
    private Map<Object, Object> map;

}

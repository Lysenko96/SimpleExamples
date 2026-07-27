package com.example.spring.repository;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Component
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example.spring")
public class ConnectionPool {

    private String name;
    private Integer poolSize;
    private List<Object> objects;
    private Map<Object, Object> map;

    public ConnectionPool(@Value("${db.name}") String name) {
        this.name = name;
    }
}

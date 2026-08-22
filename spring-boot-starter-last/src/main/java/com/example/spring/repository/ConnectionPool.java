package com.example.spring.repository;

import jakarta.annotation.PostConstruct;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
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
//@Component
@Slf4j
public class ConnectionPool {

    private String name;
    private Integer poolSize;
    private List<Object> objects;
    private Map<Object, Object> map;

    public ConnectionPool(@Value("${db.name}") String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        log.info("init ConnectionPool");
    }
}

package com.example.spring.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName = "prototype")
public class UserDto {

    public void init(){
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}

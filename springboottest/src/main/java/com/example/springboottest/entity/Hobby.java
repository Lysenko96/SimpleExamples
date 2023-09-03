package com.example.springboottest.entity;

import org.springframework.stereotype.Component;

@Component
public class Hobby {

    public String generateHobby(String name){
        return "You hobby " + name + " is cool!";
    }
}

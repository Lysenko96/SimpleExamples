package com.example.springboottest.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Data
@Service
@Scope("prototype")
public class User {

    private long id;

    private Hobby hobby;

    @Autowired
    public User(Hobby hobby) {
        this.hobby = hobby;
    }

    public double calculate(double a, double b, String operation){
        double result = 0;
        if(operation.equals("+")){
            result = a + b;
        } else if(operation.equals("-")){
            result = a - b;
        } else if(operation.equals("*")){
            result = a * b;
        } else if(operation.equals("/")){
            result = a / b;
        }
        return result;
    }

    public String checkHobby(String name){
        // method execute 2 times
        hobby.generateHobby(name);
        return hobby.generateHobby(name);
    }

}

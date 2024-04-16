package com.example.springiocdemo.model;

import com.example.springiocdemo.config.Bean;

@Bean("customBean")
public class CustomBean {

    public void printCustomBean() {
        System.out.println(this.getClass().getSimpleName());
    }
}

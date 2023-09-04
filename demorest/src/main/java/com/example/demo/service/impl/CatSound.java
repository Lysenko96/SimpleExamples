package com.example.demo.service.impl;

import com.example.demo.service.Sound;
import org.springframework.stereotype.Service;

@Service
public class CatSound implements Sound {

    @Override
    public String sound() {
        return "meow";
    }

}

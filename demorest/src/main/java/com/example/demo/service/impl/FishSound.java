package com.example.demo.service.impl;

import com.example.demo.service.Sound;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("fish")
public class FishSound implements Sound {

    @Override
    public String sound() {
        return "blub";
    }
}

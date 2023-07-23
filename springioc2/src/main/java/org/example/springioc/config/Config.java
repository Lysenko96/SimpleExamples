package org.example.springioc.config;

import org.example.springioc.entity.Signer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.springioc")
public class Config {

    @Bean(name = {"signer","mySigner","theMySigner"})
    public Signer signer(){
        return new Signer();
    }
}

package org.example.springioc3.config;

import org.example.springioc3.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean("fooImplOne1")
    //@Primary
    public FooImplOne fooImplOne(){
        return new FooImplOne();
    }

    @Bean("fooImplTwo2")
    public FooImplTwo fooImplTwo(){
        return new FooImplTwo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public Target target(){
        return new Target();
    }


}

package org.example.springioc.cofig;

import org.example.springioc.entity.Human;
import org.example.springioc.entity.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Job job(){
        return new Job();
    }

    @Bean
    public Human human(){
        return new Human();
    }

    @Bean
    public Human humanWithJob(){
        return new Human(job());
    }
}

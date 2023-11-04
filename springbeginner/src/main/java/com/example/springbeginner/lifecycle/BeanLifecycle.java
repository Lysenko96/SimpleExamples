package com.example.springbeginner.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycle {

    private String value;

    public BeanLifecycle() {
        value = "begin";
    }

    @PostConstruct
    public void init(){
        System.out.println("init " + BeanLifecycle.class.getName());
        this.value = "init";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy " + BeanLifecycle.class.getName());
        this.value = "destroy";
    }

    @Override
    public String toString() {
        return "BeanLifecycle{" +
                "value='" + value + '\'' +
                '}';
    }
}

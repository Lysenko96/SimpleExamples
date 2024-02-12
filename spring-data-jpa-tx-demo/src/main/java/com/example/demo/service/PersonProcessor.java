package com.example.demo.service;

import com.example.demo.entity.Person;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonProcessor {

    @Async
    public void processPerson(List<Person> persons) {
        System.out.println(Thread.currentThread());
        persons.forEach(p -> System.out.println(p.getNotes()));
    }
}

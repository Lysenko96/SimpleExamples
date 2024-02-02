package com.example.demo.controller;


import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Note;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.util.RequestMetaInfo;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostConstruct
    public void init() {
        Person person = new Person("first", "last");
        person.addNote(new Note("my new note..."));
        person.addNote(new Note("note second, check something"));
        System.out.println(personService.save(person));
    }

//    @GetMapping
//    public List<PersonDto> getAll(HttpServletRequest request) {
//        RequestMetaInfo.setIp(request.getRemoteAddr());
//        return personService.getAll()
//                .stream()
//                .map(p -> new PersonDto(p.getFirstName(), p.getLastName()))
//                .collect(Collectors.toList());
//    }

    @GetMapping
    public List<Person> getAll(){
        System.out.println("loaded");
        return personService.getAll();
    }
}

package com.example.persons.controller;

import com.example.persons.dto.PersonDto;
import com.example.persons.entity.Person;
import com.example.persons.repository.PersonRepository;
import com.example.persons.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{personId}")
    public PersonDto getPersonWithNotes(@PathVariable  Long personId){
        return personService.getWithNotesById(personId);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Note;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@Transactional
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void init() {
        if (personRepository.findAll().isEmpty()) {
            Person person = new Person("Oksana", "TechRedactor");
            Note note = new Note("checking links...");
            Note note2 = new Note("working...");
            person.addNote(note);
            person.addNote(note2);
            personRepository.save(person);
        }
    }

    @JsonIgnoreProperties(value = {"notes"})
    @GetMapping("/all")
    public List<Person> getAll() {
        List<Person> persons = personRepository.findAll();
        for (Person person : persons) {
            person.setNotes(null);  // without don't work json error
        }
        return persons;
    }


    @GetMapping("/fetch/all")
    public List<Person> getAllFetch() {
        return personRepository.findAllFetch();
    }

    //spring.jpa.open-in-view=true don't work
    @GetMapping("/lastName")
    public List<Person> getAllByLastName(@RequestParam String lastName) {
        return personRepository.findAllByLastName(lastName);
    }

    @GetMapping("/fetch/lastName")
    public List<Person> getAllByLastNameFetchNotes(@RequestParam String lastName) {
        return personRepository.findAllByLastNameCustomFetchNotes(lastName);
    }

}

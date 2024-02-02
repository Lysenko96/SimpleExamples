package com.example.demo.controller;

import com.example.demo.entity.Note;
import com.example.demo.entity.Person;
import com.example.demo.entity.Reminder;
import com.example.demo.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
        Person person = new Person("first", "last", "email");
        person.addNote(new Note("my note"));
        person.addReminder(new Reminder("todo...", LocalDateTime.now().plusDays(1), Reminder.Priority.MEDIUM));
        Person person1 = new Person("first1", "last1", "email1");
        person1.addNote(new Note("my note1"));
        person1.addReminder(new Reminder("todo1...", LocalDateTime.now().plusDays(1), Reminder.Priority.HIGH));
        Person person2 = new Person("first2", "last2", "email2");
        person2.addNote(new Note("my note2"));
        person2.addReminder(new Reminder("todo2...", LocalDateTime.now().plusDays(1), Reminder.Priority.LOW));
        personRepository.save(person);
        personRepository.save(person1);
        personRepository.save(person2);
    }

    @GetMapping("/{startId}/{endId}")
    public List<Person> getPersons(@PathVariable Long startId, @PathVariable Long endId) {
        List<Person> persons = personRepository.findAllByIdGreaterThanEqualAndIdLessThanAndNotes(startId, endId);
        return !persons.isEmpty() ? personRepository.findAllByIdGreaterThanEqualAndIdLessThanAAndReminders(startId, endId) : persons;
    }
}

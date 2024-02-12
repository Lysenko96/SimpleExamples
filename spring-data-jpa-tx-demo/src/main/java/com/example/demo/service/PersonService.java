package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.util.RequestMetaInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonProcessor personProcessor;

    public PersonService(PersonRepository personRepository, PersonProcessor personProcessor) {
        this.personRepository = personRepository;
        this.personProcessor = personProcessor;
    }

    @Transactional(readOnly = true)
    public List<Person> getAll() {
//        System.out.println(Thread.currentThread());
//        System.out.println(RequestMetaInfo.getCurrentIp());
//        List<Person> persons = personRepository.findAll();
//        personProcessor.processPerson(persons);
//        return persons;
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}

package org.example.web.service;

import lombok.RequiredArgsConstructor;
import org.example.web.entity.Person;
import org.example.web.exception.LowSalaryException;
import org.example.web.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public int getSalarySumByAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .mapToInt(Person::getSalary)
                .sum();
    }

    public void hire(Person person) {
        if (person.getSalary() < 1000) {
            throw new LowSalaryException("Salary must be greater or equals 1000");
        }
        personRepository.save(person);
    }

    public Person findById(int id) {
        return personRepository.findById(id);
    }

    public void update(Person person) {
        personRepository.update(person);
    }

}
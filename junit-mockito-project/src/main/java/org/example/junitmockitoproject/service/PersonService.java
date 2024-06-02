package org.example.junitmockitoproject.service;

import lombok.RequiredArgsConstructor;
import org.example.junitmockitoproject.entity.Person;
import org.example.junitmockitoproject.exception.LowSalaryException;
import org.example.junitmockitoproject.repository.PersonRepository;
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

}
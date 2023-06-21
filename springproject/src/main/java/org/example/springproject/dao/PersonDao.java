package org.example.springproject.dao;

import org.example.springproject.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonDao {

    void add(Person person);

    List<Person> getAll();

    Person getById(long id);

    void update(Person person);

    void deleteById(long id);
}

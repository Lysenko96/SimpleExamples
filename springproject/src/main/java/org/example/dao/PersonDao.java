package org.example.dao;

import org.example.model.Person;

import java.util.List;

public interface PersonDao {

    void add(Person person);

    List<Person> getAll();

    Person getById(long id);

    void update(Person person);

    void deleteById(long id);
}

package org.gweep.springpet.dao;

import org.gweep.springpet.model.Person;

import java.util.List;

public interface PersonDao {

    void save(Person person);

    Person getById(long id);

    List<Person> getAll();

    void update(Person person);

    void deleteById(long id);
}

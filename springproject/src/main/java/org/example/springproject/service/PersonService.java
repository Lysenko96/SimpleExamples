package org.example.springproject.service;

import org.example.springproject.dao.PersonDao;
import org.example.springproject.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void add(Person person) {
        personDao.add(person);
    }

    public Person getById(long id) {
        return personDao.getById(id);
    }

    public List<Person> getAll() {
        return personDao.getAll();
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void deleteById(long id) {
        personDao.deleteById(id);
    }

}

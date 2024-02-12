package org.example.demo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.demo.entity.Person;
import org.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    // don't work @Transactional because not in proxy
//    public void updateLastNameById(Long personId, String newLastName) {
//        System.out.println(this.getClass()); // not proxy class
//        doUpdateLastNameById(personId, newLastName);
//    }

    //@Transactional set class as proxy
    @Transactional(readOnly = true) // work dirty checking don't need saving person
    public void doUpdateLastNameById(EntityManager em, Long personId, String newLastName) {
        Person person = personRepository.findById(personId).orElseThrow();
//        Person person = em.find(Person.class, personId);
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        person.setLastName(newLastName);
        //tx.commit();
        //personRepository.save(person);
    }
}

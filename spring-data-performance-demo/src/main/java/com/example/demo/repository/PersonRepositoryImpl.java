package com.example.demo.repository;

import com.example.demo.entity.Person;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonRepositoryImpl implements CustomPersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAllByRangeFetchNotesAndReminders(Long startId, Long endId) {
        List<Long> personsIdWithNotes = entityManager.createQuery("SELECT DISTINCT p FROM Person p INNER JOIN FETCH p.notes WHERE p.id >= ?1 AND p.id < ?2", Person.class)
                .setParameter(1, startId)
                .setParameter(2, endId)
                .getResultList().stream()
                .map(Person::getId)
                .toList();
        return entityManager.createQuery("SELECT DISTINCT p FROM Person p INNER JOIN FETCH p.reminders WHERE p.id in ?1", Person.class)
                .setParameter(1, personsIdWithNotes)
                .getResultList();
    }

    public void createPerson(Person person) {
        entityManager.createQuery("insert Person (firstName, lastName, email, createdAt) values (?1, ?2, ?3, ?4)")
                .setParameter(1, person.getFirstName())
                .setParameter(2, person.getLastName())
                .setParameter(3, person.getEmail())
                .executeUpdate();
    }
}

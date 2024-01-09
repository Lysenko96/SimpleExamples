package org.example.springbootpersistence.service;

import jakarta.transaction.Transactional;
import org.example.springbootpersistence.entity.Note;
import org.example.springbootpersistence.entity.Person;
import org.example.springbootpersistence.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonalNoteService {

    private PersonRepository personRepository;

    public PersonalNoteService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addNote(Long personId, Note note) {
        Person person = personRepository.findById(personId)
                .orElseThrow();
        person.addNote(note);
    }
}

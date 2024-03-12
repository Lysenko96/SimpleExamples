package com.example.persons.service;

import com.example.persons.client.NotesClient;
import com.example.persons.dto.NoteDto;
import com.example.persons.dto.PersonDto;
import com.example.persons.entity.Person;
import com.example.persons.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;
    private final DiscoveryClient discoveryClient;
    private final NotesClient notesClient;

    public PersonDto getWithNotesById(Long personId) {
        Person person = personRepository.findById(personId).orElse(null);
        List<ServiceInstance> noteInstances = discoveryClient.getInstances("notes");
        ServiceInstance instance = noteInstances.get(0);
        log.info(instance.getUri().toString());
        List<NoteDto> noteDtos = notesClient.getNoteByPersonId(personId);
        return person != null ? new PersonDto(person.getFirstName(), person.getLastName(), noteDtos) : null;
    }
}

package com.example.demo.service;

import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import com.example.demo.entity.Person;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.PersonRepositoryImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final PersonRepositoryImpl personRepository;

    public NoteService(NoteRepository noteRepository, PersonRepositoryImpl personRepository) {
        this.noteRepository = noteRepository;
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Note> processNotes(Long startId, Long endId) {
        System.out.printf("Processing notes from id: %s to %s" + System.lineSeparator(), startId, endId);
        return noteRepository.findAllByRange(startId, endId);
    }

    @PostConstruct
    public void init() {
        personRepository.createPerson(new Person("1", "1", "1"));
    }

    @Transactional(readOnly = true)
    public List<NoteDto> processNotesDto(Long startId, Long endId) {
        System.out.printf("Processing notesDto from id: %s to %s" + System.lineSeparator(), startId, endId);
        return noteRepository.findAllDtoByRange(startId, endId);
    }
}

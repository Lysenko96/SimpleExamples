package com.example.demo.service;

import com.example.demo.dto.NoteDto;
import com.example.demo.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Transactional(readOnly = true)
    public List<NoteDto> getAllNoteDto() {
        return noteRepository.findAllFetchPerson().stream()
                .map(n -> new NoteDto(n.getBody(), n.getPerson().getFirstName(), n.getPerson().getLastName()))
                .collect(Collectors.toList());
    }
}
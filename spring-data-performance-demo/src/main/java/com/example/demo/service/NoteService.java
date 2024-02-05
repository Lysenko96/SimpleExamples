package com.example.demo.service;

import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Transactional(readOnly = true)
    public List<Note> processNotes(Long startId, Long endId) {
        System.out.printf("Processing notes from id: %s to %s" + System.lineSeparator(), startId, endId);
        return noteRepository.findAllByRange(startId, endId);
    }

    @Transactional(readOnly = true)
    public List<NoteDto> processNotesDto(Long startId, Long endId) {
        System.out.printf("Processing notesDto from id: %s to %s" + System.lineSeparator(), startId, endId);
        return noteRepository.findAllDtoByRange(startId, endId);
    }
}

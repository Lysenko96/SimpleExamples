package com.example.demo.controller;

import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.NoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    private final NoteRepository noteRepository;

    public NoteController(NoteService noteService, NoteRepository noteRepository) {
        this.noteService = noteService;
        this.noteRepository = noteRepository;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<Note> getAll() {
       // return noteService.getAllNoteDto();
//        return noteRepository.findAllDtos();
        return noteRepository.findAllBy().collect(Collectors.toList());
        //return new SliceImpl<>(notes, pageable, true);
        //return noteRepository.findAll(pageable);
    }
}

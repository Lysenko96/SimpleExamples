package com.example.notes.controller;

import com.example.notes.entity.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    public List<Note> getNoteByPersonId(@RequestParam Long personId) {
        return noteRepository.findAllByPersonId(personId);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note){
        return noteRepository.save(note);
    }
}

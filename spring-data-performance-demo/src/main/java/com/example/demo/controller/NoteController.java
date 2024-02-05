package com.example.demo.controller;

import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/process/{startId}/{endId}")
    public List<Note> processNotes(@PathVariable Long startId, @PathVariable Long endId) {
       return noteService.processNotes(startId, endId);
    }
    @GetMapping("/process/dto/{startId}/{endId}")
    public List<NoteDto> processNotesDto(@PathVariable Long startId, @PathVariable Long endId) {
        return noteService.processNotesDto(startId, endId);
    }
}

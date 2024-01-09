package org.example.springbootpersistence.controller;

import org.example.springbootpersistence.entity.Note;
import org.example.springbootpersistence.service.PersonalNoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons/{personId}/notes")
public class PersonalNotesController {

    private PersonalNoteService personalNoteService;

    public PersonalNotesController(PersonalNoteService personalNoteService) {
        this.personalNoteService = personalNoteService;
    }

    @PostMapping
    public void addNote(@PathVariable Long personId, @RequestBody Note note) {
        personalNoteService.addNote(personId, note);
    }
}

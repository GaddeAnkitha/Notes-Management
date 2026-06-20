package com.srgec.Notes_Management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.srgec.Notes_Management.model.Note;
import com.srgec.Notes_Management.service.NotesService;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*")
public class NotesController {

    private final NotesService service;

    public NotesController(NotesService service) {
        this.service = service;
    }
    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return service.addNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes(@RequestParam int page,
            @RequestParam int size) {
        return service.getAllNotes(page, size);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id) {
        return service.getNoteById(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable int id,
            @RequestBody Note note) {
        note.setId(id);
        return service.updateNote(note);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable int id) {
        service.deleteNote(id);
        return "Note deleted successfully";
    }
}
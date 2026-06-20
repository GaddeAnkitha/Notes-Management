package com.srgec.Notes_Management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.srgec.Notes_Management.model.Note;
import com.srgec.Notes_Management.repository.NoteRepository;

@Service
public class NotesService {

    private final NoteRepository repository;

    public NotesService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> getAllNotes(int page, int size) {
        Pageable request = PageRequest.of(page, size, Sort.by("title").ascending());
        Page<Note> pages = repository.findAll(request);
        return pages.getContent();
    }

    public Note getNoteById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note Not Found"));
    }

    public Note addNote(Note note) {
        return repository.save(note);
    }

    public Note updateNote(Note note) {
        return repository.save(note);
    }

    public void deleteNote(int id) {
        repository.deleteById(id);
    }
}
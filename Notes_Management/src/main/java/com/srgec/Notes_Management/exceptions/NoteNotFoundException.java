package com.srgec.Notes_Management.exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException() {
        super("Note Not Found");
    }
}
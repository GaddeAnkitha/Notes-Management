package com.srgec.Notes_Management.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.srgec.Notes_Management.dto.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleException(RuntimeException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(
            UserNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(NoteNotFoundException.class)
    public ErrorResponse handleNoteNotFoundException(
            NoteNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ErrorResponse handleNoteNotFoundException(
            InvalidPasswordException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
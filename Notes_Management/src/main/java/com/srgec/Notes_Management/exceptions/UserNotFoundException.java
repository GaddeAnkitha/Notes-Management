package com.srgec.Notes_Management.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User Not Found");
    }
}
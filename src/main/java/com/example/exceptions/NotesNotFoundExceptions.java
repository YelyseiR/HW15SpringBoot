package com.example.exceptions;

public class NotesNotFoundExceptions extends Exception {

    public NotesNotFoundExceptions(Long id) {
        super("Note with id '" + id + "' not found");
    }
}

package com.notes.backend.exceptions;

public class NotUniqueLoginException extends Exception {

    @Override
    public String getMessage() {
        return "This login already exists.";
    }
}

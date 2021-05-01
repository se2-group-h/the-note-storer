package com.notes.backend.exceptions;

public class EmptyFirstNameException extends Exception {

    @Override
    public String getMessage() {
        return "Empty first name.";
    }
}

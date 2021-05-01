package com.notes.backend.exceptions;

public class EmptyLastNameException extends Exception {

    @Override
    public String getMessage() {
        return "Empty last name.";
    }
}

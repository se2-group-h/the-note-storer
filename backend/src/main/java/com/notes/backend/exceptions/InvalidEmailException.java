package com.notes.backend.exceptions;

public class InvalidEmailException extends Exception {

    @Override
    public String getMessage() {
        return "Invalid email format.";
    }
}

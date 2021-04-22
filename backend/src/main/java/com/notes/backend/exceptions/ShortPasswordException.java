package com.notes.backend.exceptions;

public class ShortPasswordException extends Exception {

    @Override
    public String getMessage() {
        return "Too short password.";
    }
}

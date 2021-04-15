package com.notes.backend.exceptions;

public class BadCredentialsException extends Exception {

    @Override
    public String getMessage() {
        return "Bad credentials";
    }
}

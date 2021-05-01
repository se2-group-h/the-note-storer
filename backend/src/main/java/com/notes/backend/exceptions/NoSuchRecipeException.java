package com.notes.backend.exceptions;

public class NoSuchRecipeException extends Exception {

    @Override
    public String getMessage() {
        return "Bad credentials";
    }
}

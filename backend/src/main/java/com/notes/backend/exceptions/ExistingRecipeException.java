package com.notes.backend.exceptions;

public class ExistingRecipeException extends Exception {

    @Override
    public String getMessage() {
        return "New recipe id should be zero.";
    }
}

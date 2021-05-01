package com.notes.backend.exceptions;

public class NuSuchUserException extends Exception {
    @Override
    public String getMessage() {
        return "User with such id does not exist";
    }
}

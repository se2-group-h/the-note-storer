package com.notes.backend.chains;

import com.notes.backend.entities.User;

public interface Validator {
    boolean validate(User user) throws Exception;
}

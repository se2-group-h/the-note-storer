package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.EmptyFirstNameException;
import org.springframework.stereotype.Component;

@Component
public class FirstNameValidator implements Validator {

    @Override
    public boolean validate(User user) throws EmptyFirstNameException {
        if (user.getName() == null) {
            throw new EmptyFirstNameException();
        }
        if (!user.getName().trim().isEmpty()) {
            return true;
        } else {
            throw new EmptyFirstNameException();
        }
    }
}

package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.EmptyLastNameException;
import org.springframework.stereotype.Component;

@Component
public class LastNameValidator implements Validator {

    @Override
    public boolean validate(User user) throws EmptyLastNameException {
        if (user.getSurname() == null) {
            throw new EmptyLastNameException();
        }
        if (!user.getSurname().trim().isEmpty()) {
            return true;
        } else {
            throw new EmptyLastNameException();
        }
    }
}

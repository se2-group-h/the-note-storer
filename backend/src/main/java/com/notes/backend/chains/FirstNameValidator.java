package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.springframework.stereotype.Component;

@Component
public class FirstNameValidator implements Validator {

    @Override
    public boolean validate(User user) {
        if (user.getFirstName() == null) {
            return false;
        }
        return !user.getFirstName().trim().isEmpty();
    }
}

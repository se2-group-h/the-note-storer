package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.springframework.stereotype.Component;

@Component
public class LastNameValidator implements Validator {
    @Override
    public boolean validate(User user) {
        return !user.getLastName().trim().isEmpty();
    }
}

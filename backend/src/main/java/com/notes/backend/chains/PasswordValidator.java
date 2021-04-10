package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator {

    @Override
    public boolean validate(User user) {
        return user.getPassword().length() > 5;
    }
}

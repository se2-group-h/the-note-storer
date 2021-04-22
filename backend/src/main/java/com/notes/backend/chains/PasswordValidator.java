package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.ShortPasswordException;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator {

    @Override
    public boolean validate(User user) throws ShortPasswordException {
        if (user.getPassword() == null) {
            throw new ShortPasswordException();
        }
        if (user.getPassword().length() > 5) {
            return true;
        } else {
            throw new ShortPasswordException();
        }
    }
}

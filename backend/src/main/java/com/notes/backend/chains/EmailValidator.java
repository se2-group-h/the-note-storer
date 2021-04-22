package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.InvalidEmailException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Validator {

    @Override
    public boolean validate(User user) throws InvalidEmailException {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }
        String ePattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(user.getEmail());
        if (m.matches()) {
            return true;
        } else {
            throw new InvalidEmailException();
        }
    }
}

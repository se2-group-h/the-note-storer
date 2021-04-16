package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Validator {

    @Override
    public boolean validate(User user) {
        if (user.getEmail() == null) {
            return false;
        }
        String ePattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(user.getEmail());
        return m.matches();
    }
}

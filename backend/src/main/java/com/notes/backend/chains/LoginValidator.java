package com.notes.backend.chains;

import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.User;
import com.notes.backend.exceptions.NotUniqueLoginException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean validate(User user) throws NotUniqueLoginException {
        if (user.getLogin() == null || user.getLogin().trim().isEmpty()) {
            throw new NotUniqueLoginException();
        }
        if (!userRepository.existsByLogin(user.getLogin())) {
            return true;
        } else {
            throw new NotUniqueLoginException();
        }
    }
}

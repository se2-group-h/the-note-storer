package com.notes.backend.chains;

import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean validate(User user) {
        return !userRepository.existsByLogin(user.getLogin());
    }
}

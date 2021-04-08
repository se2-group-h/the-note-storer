package com.notes.backend.services;

import com.notes.backend.chains.Validator;
import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final List<Validator> validationChain;
    private final UserRepository userRepository;

    public User saveNewUser(User newUser) {
        newUser.setUserId(0);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public boolean validateUser(User user) {
        for (Validator validator : validationChain) {
            if (!validator.validate(user)) {
                return false;
            }
        }
        return true;
    }
}

package com.notes.backend.dao;

import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByCorrectLogin() {
        Optional<User> user = userRepository.findByLogin("Hookah Man");
        assertTrue(user.isPresent());
    }

    @Test
    void findByIncorrectLogin() {
        Optional<User> user = userRepository.findByLogin("Dino");
        assertFalse(user.isPresent());
    }

    @Test
    void existsByExistingLogin() {
        boolean exists = userRepository.existsByLogin("Hookah Man");
        assertTrue(exists);
    }

    @Test
    void existsByNonExistingLogin() {
        boolean exists = userRepository.existsByLogin("TestUser");
        assertFalse(exists);
    }
}
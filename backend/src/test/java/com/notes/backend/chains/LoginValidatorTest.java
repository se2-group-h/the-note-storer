package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.EmptyFirstNameException;
import com.notes.backend.exceptions.NotUniqueLoginException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("dev")
class LoginValidatorTest {

    @Autowired
    private LoginValidator loginValidator;
    private User testUser = new User();

    @Test
    void nonExistingValidLogin() throws NotUniqueLoginException {
        testUser.setLogin("qwerty");
        loginValidator.validate(testUser);
    }

    @Test
    void emptyLogin() {
        testUser.setLogin("");
        assertThrows(NotUniqueLoginException.class, () -> loginValidator.validate(testUser));
    }

    @Test
    void spaceLogin() {
        testUser.setLogin(" ");
        assertThrows(NotUniqueLoginException.class, () -> loginValidator.validate(testUser));
    }

    @Test
    void nullLogin() {
        testUser.setLogin(null);
        assertThrows(NotUniqueLoginException.class, () -> loginValidator.validate(testUser));
    }

    @Test
    void existingLogin() {
        testUser.setLogin("Hookah Man");
        assertThrows(NotUniqueLoginException.class, () -> loginValidator.validate(testUser));
    }
}
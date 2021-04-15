package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ActiveProfiles("dev")
class LoginValidatorTest {

    @Autowired
    private LoginValidator loginValidator;
    private User testUser = new User();

    @Test
    void nonExistingValidLogin() {
        testUser.setLogin("qwerty");
        boolean isValid = loginValidator.validate(testUser);
        assertTrue(isValid);
    }

    @Test
    void emptyLogin() {
        testUser.setLogin("");
        boolean isValid = loginValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void spaceLogin() {
        testUser.setLogin(" ");
        boolean isValid = loginValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void nullLogin() {
        testUser.setLogin(null);
        boolean isValid = loginValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void existingLogin() {
        testUser.setLogin("Hookah Man");
        boolean isValid = loginValidator.validate(testUser);
        assertFalse(isValid);
    }
}
package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private User testUser = new User();
    private PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    void correctPassword() {
        testUser.setPassword("123456");
        boolean isValid = passwordValidator.validate(testUser);
        assertTrue(isValid);
    }

    @Test
    void shortPassword() {
        testUser.setPassword("123");
        boolean isValid = passwordValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void emptyPassword() {
        testUser.setPassword("");
        boolean isValid = passwordValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void spacePassword() {
        testUser.setPassword(" ");
        boolean isValid = passwordValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void nullPassword() {
        testUser.setPassword(null);
        boolean isValid = passwordValidator.validate(testUser);
        assertFalse(isValid);
    }
}
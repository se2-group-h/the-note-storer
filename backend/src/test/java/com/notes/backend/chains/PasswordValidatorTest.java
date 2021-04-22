package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.NotUniqueLoginException;
import com.notes.backend.exceptions.ShortPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private User testUser = new User();
    private PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    void correctPassword() throws ShortPasswordException {
        testUser.setPassword("123456");
        passwordValidator.validate(testUser);
    }

    @Test
    void shortPassword() {
        testUser.setPassword("123");
        assertThrows(ShortPasswordException.class, () -> passwordValidator.validate(testUser));
    }

    @Test
    void emptyPassword() {
        testUser.setPassword("");
        assertThrows(ShortPasswordException.class, () -> passwordValidator.validate(testUser));
    }

    @Test
    void spacePassword() {
        testUser.setPassword(" ");
        assertThrows(ShortPasswordException.class, () -> passwordValidator.validate(testUser));
    }

    @Test
    void nullPassword() {
        testUser.setPassword(null);
        assertThrows(ShortPasswordException.class, () -> passwordValidator.validate(testUser));
    }
}
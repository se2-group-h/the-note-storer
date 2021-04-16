package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private User testUser = new User();
    private EmailValidator emailValidator = new EmailValidator();

    @Test
    void correctEmail() {
        testUser.setEmail("roma@gmail.com");
        boolean isValid = emailValidator.validate(testUser);
        assertTrue(isValid);
    }

    @Test
    void correctEmailWithDotInLocalPart() {
        testUser.setEmail("roma.shev@gmail.com");
        boolean isValid = emailValidator.validate(testUser);
        assertTrue(isValid);
    }

    @Test
    void noLocalName() {
        testUser.setEmail("@gmail.com");
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void noDomainName() {
        testUser.setEmail("roma@");
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void noAtSymbol() {
        testUser.setEmail("romagmail.com");
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void oneDotBeforeDomain() {
        testUser.setEmail(".@gmail.com");
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void twoDotsBeforeDomain() {
        testUser.setEmail("..@gmail.com");
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void nullEmail() {
        testUser.setEmail(null);
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void emptyEmail() {
        testUser.setEmail("");
        boolean isValid = emailValidator.validate(testUser);
        assertFalse(isValid);
    }
}
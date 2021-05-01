package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private User testUser = new User();
    private EmailValidator emailValidator = new EmailValidator();

    @Test
    void correctEmail() throws Exception {
        testUser.setEmail("roma@gmail.com");
        emailValidator.validate(testUser);
    }

    @Test
    void correctEmailWithDotInLocalPart() throws Exception {
        testUser.setEmail("roma.shev@gmail.com");
        emailValidator.validate(testUser);
    }

    @Test
    void noLocalName() {
        testUser.setEmail("@gmail.com");
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }

    @Test
    void noDomainName() {
        testUser.setEmail("roma@");
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }

    @Test
    void noAtSymbol() {
        testUser.setEmail("romagmail.com");
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }

    @Test
    void oneDotBeforeDomain() {
        testUser.setEmail(".@gmail.com");
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }

    @Test
    void twoDotsBeforeDomain() {
        testUser.setEmail("..@gmail.com");
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }

    @Test
    void nullEmail() {
        testUser.setEmail(null);
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }

    @Test
    void emptyEmail() {
        testUser.setEmail("");
        assertThrows(InvalidEmailException.class, () -> emailValidator.validate(testUser));
    }
}
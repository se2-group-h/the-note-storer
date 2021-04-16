package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNameValidatorTest {

    private User testUser = new User();
    private FirstNameValidator firstNameValidator = new FirstNameValidator();

    @Test
    void nonEmptyFirstName() {
        testUser.setFirstName("Roman");
        boolean isValid = firstNameValidator.validate(testUser);
        assertTrue(isValid);
    }

    @Test
    void emptyFirstName() {
        testUser.setFirstName("");
        boolean isValid = firstNameValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void spaceFirstName() {
        testUser.setFirstName(" ");
        boolean isValid = firstNameValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void twoSpacesFirstName() {
        testUser.setFirstName("  ");
        boolean isValid = firstNameValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    void nullFirstName() {
        testUser.setFirstName(null);
        boolean isValid = firstNameValidator.validate(testUser);
        assertFalse(isValid);
    }
}
package com.notes.backend.chains;

import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastNameValidatorTest {

    private User testUser = new User();
    private LastNameValidator lastNameValidator = new LastNameValidator();

    @Test
    public void nonEmptyLastName() {
        testUser.setLastName("Shevchuk");
        boolean isValid = lastNameValidator.validate(testUser);
        assertTrue(isValid);
    }

    @Test
    public void emptyLastName() {
        testUser.setLastName("");
        boolean isValid = lastNameValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    public void spaceLastName() {
        testUser.setLastName(" ");
        boolean isValid = lastNameValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    public void twoSpacesLastName() {
        testUser.setLastName(" ");
        boolean isValid = lastNameValidator.validate(testUser);
        assertFalse(isValid);
    }

    @Test
    public void nullLastName() {
        testUser.setLastName(null);
        boolean isValid = lastNameValidator.validate(testUser);
        assertFalse(isValid);
    }
}
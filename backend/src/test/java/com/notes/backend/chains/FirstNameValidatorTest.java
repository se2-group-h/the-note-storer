package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.EmptyFirstNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNameValidatorTest {

    private User testUser = new User();
    private FirstNameValidator firstNameValidator = new FirstNameValidator();

    @Test
    void nonEmptyFirstName() throws EmptyFirstNameException {
        testUser.setName("Roman");
        firstNameValidator.validate(testUser);
    }

    @Test
    void emptyFirstName() {
        testUser.setName("");
        assertThrows(EmptyFirstNameException.class, () -> firstNameValidator.validate(testUser));
    }

    @Test
    void spaceFirstName() {
        testUser.setName(" ");
        assertThrows(EmptyFirstNameException.class, () -> firstNameValidator.validate(testUser));
    }

    @Test
    void twoSpacesFirstName() {
        testUser.setName("  ");
        assertThrows(EmptyFirstNameException.class, () -> firstNameValidator.validate(testUser));
    }

    @Test
    void nullFirstName() {
        testUser.setName(null);
        assertThrows(EmptyFirstNameException.class, () -> firstNameValidator.validate(testUser));
    }
}
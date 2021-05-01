package com.notes.backend.chains;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.EmptyLastNameException;
import com.notes.backend.exceptions.ShortPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastNameValidatorTest {

    private User testUser = new User();
    private LastNameValidator lastNameValidator = new LastNameValidator();

    @Test
    public void nonEmptyLastName() throws EmptyLastNameException {
        testUser.setSurname("Shevchuk");
        lastNameValidator.validate(testUser);
    }

    @Test
    public void emptyLastName() {
        testUser.setSurname("");
        assertThrows(EmptyLastNameException.class, () -> lastNameValidator.validate(testUser));
    }

    @Test
    public void spaceLastName() {
        testUser.setSurname(" ");
        assertThrows(EmptyLastNameException.class, () -> lastNameValidator.validate(testUser));
    }

    @Test
    public void twoSpacesLastName() {
        testUser.setSurname(" ");
        assertThrows(EmptyLastNameException.class, () -> lastNameValidator.validate(testUser));
    }

    @Test
    public void nullLastName() {
        testUser.setSurname(null);
        assertThrows(EmptyLastNameException.class, () -> lastNameValidator.validate(testUser));
    }
}
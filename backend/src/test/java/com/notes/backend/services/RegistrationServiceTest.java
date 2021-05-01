package com.notes.backend.services;

import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.User;
import com.notes.backend.exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRepository userRepository;

    private User testUser = new User(0,"Roman", "Shevchuk", "Dinosaur", "qwerty", "roma@gmail.com", false, false, List.of());

    @Test
    void saveNewUser() {
        User user = new User();
        user.setUserId(0);
        user.setName("Vitaliy");
        user.setSurname("Tsal");
        user.setLogin("Papich");
        user.setPassword("12345");
        user.setEmail("spitefuldick@gmail.com");
        registrationService.saveNewUser(user);
        assertTrue(userRepository.existsByLogin(user.getLogin()));
    }

    @Test
    void validateCorrectUser() throws Exception {
        registrationService.validateUser(testUser);
    }

    @Test
    void saveNullUser() {
        assertThrows(NullPointerException.class, () -> registrationService.saveNewUser(null));
    }

    @Test
    void emptyFirstName() {
        testUser.setName("");
        assertThrows(EmptyFirstNameException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void emptyLastName() {
        testUser.setSurname("");
        assertThrows(EmptyLastNameException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void existingLogin() {
        testUser.setLogin("Papich");
        assertThrows(NotUniqueLoginException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void shortPassword() {
        testUser.setPassword("qwe");
        assertThrows(ShortPasswordException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void firstInvalidEmail() {
        testUser.setEmail("romamail.com");
        assertThrows(InvalidEmailException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void secondInvalidEmail() {
        testUser.setEmail("roma@mail");
        assertThrows(InvalidEmailException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void thirdInvalidEmail() {
        testUser.setEmail("roma.@mail.com");
        assertThrows(InvalidEmailException.class, () -> registrationService.validateUser(testUser));
    }

    @Test
    void fourthInvalidEmail() {
        testUser.setEmail("@mail.com");
        assertThrows(InvalidEmailException.class, () -> registrationService.validateUser(testUser));
    }
}
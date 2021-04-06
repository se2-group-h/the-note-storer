package com.notes.backend.controllers;

import com.notes.backend.entities.LoginForm;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
class AuthControllerTest {

    @Autowired
    private AuthController authController;

    @Test
    void correctUserCredentials() {
        LoginForm correct = new LoginForm("Hookah Man", "qwerty");
        assertTrue(authController.signIn(correct).getStatusCode().is2xxSuccessful());
    }

    @Test
    void incorrectUserCredentials() {
        LoginForm incorrect = new LoginForm("Hookah Man", "wrong pass");
        ResponseEntity<?> responseEntity = authController.signIn(incorrect);
        assertTrue(responseEntity.getStatusCode().isError());

        String message = Objects.requireNonNull(responseEntity.getBody()).toString();
        assertEquals("Bad credentials", message);
    }
}
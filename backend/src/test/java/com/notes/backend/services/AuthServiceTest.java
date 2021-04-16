package com.notes.backend.services;

import com.notes.backend.entities.AuthorizedUser;
import com.notes.backend.entities.LoginForm;
import com.notes.backend.exceptions.BadCredentialsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class AuthServiceTest {

    @Autowired
    private AuthService authService;
    private LoginForm correctCredentials = new LoginForm("Hookah Man", "qwerty");

    @Test
    void trySignInWithCorrectCredentials() throws Exception {
        AuthorizedUser authorizedUser = authService.trySignIn(correctCredentials);
        assertEquals("Roman", authorizedUser.getFirstName());
    }

    @Test
    void checkTokenPresence() throws Exception {
        AuthorizedUser authorizedUser = authService.trySignIn(correctCredentials);
        assertEquals(180, authorizedUser.getToken().length());
    }

    @Test
    void checkIdPresence() throws Exception {
        AuthorizedUser authorizedUser = authService.trySignIn(correctCredentials);
        assertEquals(1, authorizedUser.getUserId());
    }

    @Test
    void checkFirstNamePresence() throws Exception {
        AuthorizedUser authorizedUser = authService.trySignIn(correctCredentials);
        assertEquals("Roman", authorizedUser.getFirstName());
    }

    @Test
    void trySignInWithWrongCredentials() {
        LoginForm invalidCredentials = new LoginForm("Hookah Man", "qwerty1");
        assertThrows(BadCredentialsException.class, () -> authService.trySignIn(invalidCredentials));
    }

    @Test
    void trySignInWithNullCredentials() {
        assertThrows(BadCredentialsException.class, () -> authService.trySignIn(null));
    }

    @Test
    void trySignInWithNullLogin() {
        LoginForm nullLogin = new LoginForm(null, "qwerty1");
        assertThrows(BadCredentialsException.class, () -> authService.trySignIn(nullLogin));
    }

    @Test
    void trySignInWithNullPassword() {
        LoginForm nullPassword = new LoginForm("Hookah Man", null);
        assertThrows(BadCredentialsException.class, () -> authService.trySignIn(nullPassword));
    }

    @Test
    void trySignInWithBothNulls() {
        LoginForm nullFields = new LoginForm(null, null);
        assertThrows(BadCredentialsException.class, () -> authService.trySignIn(nullFields));
    }
}
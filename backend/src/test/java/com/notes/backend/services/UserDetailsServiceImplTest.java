package com.notes.backend.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void loadUserByCorrectUsername() {
        UserDetails hookahMan = userDetailsService.loadUserByUsername("Hookah Man");
        assertEquals("Hookah Man", hookahMan.getUsername());
    }

    @Test
    void loadUserByWrongUsername() {
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("Some Wrong Username"));
    }
}
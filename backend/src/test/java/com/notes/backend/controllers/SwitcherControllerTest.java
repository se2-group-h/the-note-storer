package com.notes.backend.controllers;

import com.notes.backend.configs.SecuritySwitcher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
class SwitcherControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private SecuritySwitcher securitySwitcher;

    @Test
    void toggleAuthorizationOn() throws Exception {
        MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(get("/api/auth/on"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Security turned on."));
    }

    @Test
    void checkSecurityAfterSwitchOn() throws Exception {
        MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(get("/api/auth/on"));
        assertFalse(securitySwitcher.isDisabled());
    }

    @Test
    void toggleAuthorizationOff() throws Exception {
        MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(get("/api/auth/off"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Security turned off."));
    }

    @Test
    void checkSecurityAfterSwitchOff() throws Exception {
        MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(get("/api/auth/off"));
        assertTrue(securitySwitcher.isDisabled());
    }

    @Test
    void toggleAuthorizationWithWrongState() throws Exception {
        MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(get("/api/auth/123"))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string("Bad value of security state."));
    }

    @Test
    void toggleAuthorizationWithNoState() throws Exception {
        MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(get("/api/auth/"))
                .andExpect(status().is4xxClientError());
    }
}
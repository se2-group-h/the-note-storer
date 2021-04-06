package com.notes.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notes.backend.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
class RegistrationControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Test
    void register() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        User correctUser = new User(0,"Elephant007", "qwerty", "Kiryl", "Volkau", "kiryl@gmail.com");
        mvc.perform(MockMvcRequestBuilders
                .post("/api/signup")
                .content(asJsonString(correctUser))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

    @Test
    void invalidUserRegister() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        User incorrectUser = new User(0,"Elephant007", "qwe", "Kiryl", "Volkau", "kiryl@gmail.com");
        mvc.perform(MockMvcRequestBuilders
                .post("/api/signup")
                .content(asJsonString(incorrectUser))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
package com.notes.backend.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notes.backend.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("dev")
public class E2ETests {

    @Autowired
    private WebApplicationContext context;

    @Test
    void registerAndLogin() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        User correctUser = new User(0,"TestUser1", "qwerty123456", "Test", "User", "testuser@gmail.com", false, false, List.of());
        mvc.perform(MockMvcRequestBuilders
                .post("/api/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(correctUser)))
                .andExpect(status().is2xxSuccessful());

        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        mvc.perform(MockMvcRequestBuilders
                .post("/api/login")
                .content(asJsonString(new LoginForm("TestUser1", "qwerty123456")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void loginAndRecipesFetch() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .post("/api/login")
                .content(asJsonString(new LoginForm("Hookah Man", "qwerty")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        AuthorizedUser userWithJWT = fromJsonString(contentAsString, AuthorizedUser.class);

        MvcResult recipesList = mvc.perform(MockMvcRequestBuilders
                .get("/api/recipes")
                .header("Authorization", "Bearer " + userWithJWT.getToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(recipesList.getResponse().getContentAsString().length(), greaterThan(0));
    }


    @Test
    void loginAndRecipeFetchById() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .post("/api/login")
                .content(asJsonString(new LoginForm("Hookah Man", "qwerty")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        AuthorizedUser userWithJWT = fromJsonString(contentAsString, AuthorizedUser.class);

        MvcResult recipesList = mvc.perform(MockMvcRequestBuilders
                .get("/api/recipes/" + 1)
                .header("Authorization", "Bearer " + userWithJWT.getToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(recipesList.getResponse().getContentAsString().length(), greaterThan(0));
    }


    @Test
    void loginAndSaveRecipe() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .post("/api/login")
                .content(asJsonString(new LoginForm("Hookah Man", "qwerty")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        AuthorizedUser userWithJWT = fromJsonString(contentAsString, AuthorizedUser.class);

        MvcResult getRecipe = mvc.perform(MockMvcRequestBuilders
                .get("/api/recipes/" + 1)
                .header("Authorization", "Bearer " + userWithJWT.getToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        Recipe recipe = fromJsonString(getRecipe.getResponse().getContentAsString(), Recipe.class);
        RecipeLink newRecipeLink = new RecipeLink(userWithJWT.getUserId(), recipe.getRecipeId());

        mvc.perform(MockMvcRequestBuilders
                .post("/api/saved_recipes/")
                .header("Authorization", "Bearer " + userWithJWT.getToken())
                .content(asJsonString(newRecipeLink))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void loginAndUpdateRecipe() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .post("/api/login")
                .content(asJsonString(new LoginForm("Hookah Man", "qwerty")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        AuthorizedUser userWithJWT = fromJsonString(contentAsString, AuthorizedUser.class);

        MvcResult getRecipe = mvc.perform(MockMvcRequestBuilders
                .get("/api/recipes/" + 1)
                .header("Authorization", "Bearer " + userWithJWT.getToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        Recipe recipe = fromJsonString(getRecipe.getResponse().getContentAsString(), Recipe.class);
        recipe.setName("TestName");

        MvcResult savedRecipe = mvc.perform(MockMvcRequestBuilders
                .put("/api/recipes/1")
                .header("Authorization", "Bearer " + userWithJWT.getToken())
                .content(asJsonString(recipe))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(savedRecipe.getResponse().getContentAsString().contains("TestName"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJsonString(final String string, Class<T> c) {
        try {
            return new ObjectMapper().readValue(string, c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

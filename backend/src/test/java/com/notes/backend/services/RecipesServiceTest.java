package com.notes.backend.services;

import com.notes.backend.dao.RecipeRepository;
import com.notes.backend.entities.Recipe;
import com.notes.backend.exceptions.ExistingRecipeException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
class RecipesServiceTest {

    @Autowired
    private RecipesService recipesService;

    private Recipe someRecipe = new Recipe(0, 1, "Some Meal", "Some description", "meal", 2.2f);

    @Test
    void getAllRecipes() {
        List<Recipe> allRecipes = recipesService.getAllRecipes();
        assertEquals(allRecipes.size(), 2);
    }

    @Test
    void getById() {
        Optional<Recipe> byId = recipesService.getById(1);
        assertTrue(byId.isPresent());
    }

    @Test
    void getByIdWhichDoesNotExist() {
        Optional<Recipe> byId = recipesService.getById(5);
        assertTrue(byId.isEmpty());
    }

    @Test
    void saveRecipe() throws ExistingRecipeException {
        Recipe recipe = recipesService.saveRecipe(someRecipe);
        assertTrue(recipe.getId() != 0);
    }

    @Test
    void saveRecipeWithId() {
        someRecipe.setId(14);
        assertThrows(ExistingRecipeException.class, () -> recipesService.saveRecipe(someRecipe));
    }

    @Test
    void updateRecipe() {
        someRecipe.setCreatorId(2);
        Recipe updatedRecipe = recipesService.updateRecipe(someRecipe);
        assertEquals(updatedRecipe.getCreatorId(), 2);
    }

    @Test
    void deleteRecipeById() {
        recipesService.deleteRecipeById(2);
        Optional<Recipe> byId = recipesService.getById(2);
        assertTrue(byId.isEmpty());
    }
}
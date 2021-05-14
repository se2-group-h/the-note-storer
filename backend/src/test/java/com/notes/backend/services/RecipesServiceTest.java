package com.notes.backend.services;

import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.User;
import com.notes.backend.entities.UserRecipe;
import com.notes.backend.exceptions.ExistingRecipeException;
import com.notes.backend.exceptions.NoSuchRecipeException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
class RecipesServiceTest {

    @Autowired
    private RecipesService recipesService;

    private Recipe someRecipe = new Recipe(0, 1, "Some Meal", "Some description", "meal", 2.2f, List.of());
    private User testUser = new User(0, "dino", "123456","Andrew","Whatever","some@email.com",true, false, List.of());

    @Test
    void getAllRecipes() {
        List<Recipe> allRecipes = recipesService.getAllRecipes();
        assertEquals(allRecipes.size(), 2);
    }

    @Test
    void getById() throws NoSuchRecipeException {
        Recipe byId = recipesService.getById(1);
        assertEquals(1, byId.getRecipeId());
    }

    @Test
    void getByIdWhichDoesNotExist() {
        assertThrows(NoSuchRecipeException.class, () -> recipesService.getById(5));
    }

	@Test
	void getAllUserRecipes() {
		UserRecipe userRecipe = new UserRecipe(5, testUser, someRecipe);
		testUser.setSavedRecipes(List.of(userRecipe));
		List<Recipe> allRecipes = recipesService.getUserRecipes(testUser);
		assertEquals(allRecipes.size(), 1);
	}

	@Test
	void getAllUserRecipesWithEmptyList() {
		testUser.setSavedRecipes(List.of());
		List<Recipe> allRecipes = recipesService.getUserRecipes(testUser);
		assertEquals(allRecipes.size(), 0);
	}

	@Test
	void getAllUserRecipesWithNullList() {
		testUser.setSavedRecipes(null);
		List<Recipe> allRecipes = recipesService.getUserRecipes(testUser);
		assertEquals(allRecipes.size(), 0);
	}

	@Test
	void getAllUserRecipesWithNullUser() {
		List<Recipe> allRecipes = recipesService.getUserRecipes(null);
		assertEquals(allRecipes.size(), 0);
	}

    @Test
    void saveRecipe() throws ExistingRecipeException {
        Recipe recipe = recipesService.saveRecipe(someRecipe);
        assertTrue(recipe.getRecipeId() != 0);
    }

    @Test
    void saveRecipeWithId() {
        someRecipe.setRecipeId(14);
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
        assertThrows(NoSuchRecipeException.class, () -> recipesService.getById(2));
    }
}
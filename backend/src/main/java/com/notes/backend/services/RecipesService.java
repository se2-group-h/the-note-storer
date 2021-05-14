package com.notes.backend.services;

import com.notes.backend.dao.RecipeRepository;
import com.notes.backend.dao.UserRecipeRepository;
import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.User;
import com.notes.backend.entities.UserRecipe;
import com.notes.backend.exceptions.ExistingRecipeException;
import com.notes.backend.exceptions.NoSuchRecipeException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipesService {

    private RecipeRepository recipeRepository;
    private UserRecipeRepository userRecipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getById(Integer recipeId) throws NoSuchRecipeException {
        Optional<Recipe> recipeById = recipeRepository.findById(recipeId);

        if(recipeById.isEmpty()) {
            throw new NoSuchRecipeException();
        }
        return recipeById.get();
    }

    public Recipe saveRecipe(Recipe recipe) throws ExistingRecipeException {
        if (recipe.getRecipeId() != 0) {
            throw new ExistingRecipeException();
        }
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Integer recipeId) {
        List<UserRecipe> allByRecipe_recipeId = userRecipeRepository.findAllByRecipe_RecipeId(recipeId);
        userRecipeRepository.deleteAll(allByRecipe_recipeId);
        recipeRepository.deleteById(recipeId);
    }

	public List<Recipe> getUserRecipes(User user) {
    	if (user == null || user.getSavedRecipes() == null) {
    		return Collections.emptyList();
		}
		return user.getSavedRecipes()
				.stream()
				.map(UserRecipe::getNormalRecipe)
				.collect(Collectors.toList());
	}
}

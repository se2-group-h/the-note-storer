package com.notes.backend.services;

import com.notes.backend.dao.RecipeRepository;
import com.notes.backend.entities.Recipe;
import com.notes.backend.exceptions.ExistingRecipeException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipesService {

    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getById(Integer recipeId) {
        return recipeRepository.findById(recipeId);
    }

    public Recipe saveRecipe(Recipe recipe) throws ExistingRecipeException {
        if (recipe.getId() != 0) {
            throw new ExistingRecipeException();
        }
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Integer recipeId) {
        recipeRepository.deleteById(recipeId);
    }
}

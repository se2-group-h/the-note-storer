package com.notes.backend.services;

import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.RecipeLink;
import com.notes.backend.entities.User;
import com.notes.backend.exceptions.NoSuchRecipeException;
import com.notes.backend.exceptions.NuSuchUserException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RecipesService recipesService;

    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }

    public void saveUserRecipe(RecipeLink link) throws NoSuchRecipeException, NuSuchUserException {
        Optional<Recipe> recipeById = recipesService.getById(link.getRecipeId());
        Optional<User> userById = getById(link.getUserId());

        if (recipeById.isEmpty()) {
            throw new NoSuchRecipeException();
        }

        if (userById.isEmpty()) {
            throw new NuSuchUserException();
        }

        List<Recipe> userRecipes = userById.get().getSavedRecipes();
        userRecipes.add(recipeById.get());
        userRepository.save(userById.get());
    }

    public void deleteUserRecipe(Integer userId, Integer recipeId) throws NoSuchRecipeException, NuSuchUserException {
        Optional<Recipe> recipeById = recipesService.getById(recipeId);
        Optional<User> userById = getById(userId);

        if (recipeById.isEmpty()) {
            throw new NoSuchRecipeException();
        }

        if (userById.isEmpty()) {
            throw new NuSuchUserException();
        }

        List<Recipe> userRecipes = userById.get().getSavedRecipes();
        userRecipes.removeIf(recipe -> recipe.getId().equals(recipeId));
        userRepository.save(userById.get());
    }
}

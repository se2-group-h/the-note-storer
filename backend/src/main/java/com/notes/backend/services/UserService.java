package com.notes.backend.services;

import com.notes.backend.dao.UserRecipeRepository;
import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.RecipeLink;
import com.notes.backend.entities.User;
import com.notes.backend.entities.UserRecipe;
import com.notes.backend.exceptions.NoSuchRecipeException;
import com.notes.backend.exceptions.NuSuchUserException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RecipesService recipesService;
    private UserRecipeRepository userRecipeRepository;

    public User getById(Integer userId) throws NuSuchUserException {
        Optional<User> userById =  userRepository.findById(userId);

        if (userById.isEmpty()) {
            throw new NuSuchUserException();
        }

        return userById.get();
    }

    public void saveUserRecipe(RecipeLink link) throws NoSuchRecipeException, NuSuchUserException {
        User userById = getById(link.getUserId());
        Recipe recipeById = recipesService.getById(link.getRecipeId());

        UserRecipe newLink = new UserRecipe(0, userById, recipeById);
        userRecipeRepository.save(newLink);
    }

    public void deleteUserRecipe(Integer userId, Integer recipeId) throws NoSuchRecipeException, NuSuchUserException {
        Recipe recipeById = recipesService.getById(recipeId);
        User userById = getById(userId);

        Optional<UserRecipe> byUserAndRecipe = userRecipeRepository.findByUserAndRecipe(userById, recipeById);
        byUserAndRecipe.ifPresent((entry) -> userRecipeRepository.delete(entry));
    }
}

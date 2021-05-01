package com.notes.backend.dao;

import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.User;
import com.notes.backend.entities.UserRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRecipeRepository extends JpaRepository<UserRecipe, Integer> {
    Optional<UserRecipe> findByUserAndRecipe(User user, Recipe recipe);
    List<UserRecipe> findAllByRecipe_RecipeId(Integer recipeId);
}

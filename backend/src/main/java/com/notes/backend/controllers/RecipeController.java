package com.notes.backend.controllers;

import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.User;
import com.notes.backend.exceptions.ExistingRecipeException;
import com.notes.backend.exceptions.NoSuchRecipeException;
import com.notes.backend.services.RecipesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Recipes")
@RestController
@AllArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipesService recipesService;

    @GetMapping
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> allRecipes = recipesService.getAllRecipes();
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
    public ResponseEntity<?> getRecipeInfo(@PathVariable(name = "id") Integer recipeId) {
        try {
            Recipe recipeById = recipesService.getById(recipeId);
            return new ResponseEntity<>(recipeById, HttpStatus.OK);
        } catch (NoSuchRecipeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping("/user/{userId}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
	public ResponseEntity<List<Recipe>> getUserRecipes(@PathVariable(name = "userId") User user) {
		List<Recipe> savedRecipes = recipesService.getUserRecipes(user);
		return new ResponseEntity<>(savedRecipes, HttpStatus.OK);
	}

    @PostMapping
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
    public ResponseEntity<?> saveRecipe(@RequestBody Recipe recipe) {
        try {
            Recipe savedRecipe = recipesService.saveRecipe(recipe);
            return new ResponseEntity<>(savedRecipe, HttpStatus.OK);
        } catch (ExistingRecipeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
    public ResponseEntity<?> updateRecipe(@PathVariable(name = "id") Integer recipeId, @RequestBody Recipe recipe) {
        try {
            recipesService.getById(recipeId);
            recipe.setRecipeId(recipeId);
            Recipe updateRecipe = recipesService.updateRecipe(recipe);
            return new ResponseEntity<>(updateRecipe, HttpStatus.OK);
        } catch (NoSuchRecipeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
    public ResponseEntity<?> deleteRecipe(@PathVariable(name = "id") Integer recipeId) {
        recipesService.deleteRecipeById(recipeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

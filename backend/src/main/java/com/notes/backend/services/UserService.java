package com.notes.backend.services;

import com.notes.backend.dao.UserRecipeRepository;
import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.Recipe;
import com.notes.backend.entities.RecipeLink;
import com.notes.backend.entities.User;
import com.notes.backend.entities.UserRecipe;
import com.notes.backend.exceptions.NoSuchRecipeException;
import com.notes.backend.exceptions.NuSuchUserException;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

	public List<User> searchBy(String name, String surname, String email) {
    	if (name != null && name.trim().isEmpty()) {
    		name = null;
		}
    	if (name != null && surname.trim().isEmpty()) {
    		surname = null;
		}
    	if (name != null && email.trim().isEmpty()) {
    		email = null;
		}
    	return userRepository.searchBy(name, surname, email);
	}

	public void updateUser(Integer id, User user) throws NuSuchUserException {
    	if (!userRepository.existsByUserId(id)) {
    		throw new NuSuchUserException();
		}
		User storedUser = getById(id);
    	storedUser.setName(user.getName() != null ? user.getName() : storedUser.getName());
    	storedUser.setSurname(user.getSurname() != null ? user.getSurname() : storedUser.getSurname());
    	storedUser.setPassword(user.getPassword() != null ? user.getPassword() : storedUser.getPassword());
    	userRepository.save(storedUser);
    }

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}

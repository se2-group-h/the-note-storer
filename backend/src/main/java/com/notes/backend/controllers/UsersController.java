package com.notes.backend.controllers;

import com.notes.backend.entities.User;
import com.notes.backend.exceptions.NuSuchUserException;
import com.notes.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Users")
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

	private final UserService userService;

	@GetMapping
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
	public ResponseEntity<List<User>> search(@RequestParam(required = false) String name,
											 @RequestParam(required = false) String surname,
											 @RequestParam(required = false) String email) {
		return new ResponseEntity<>(userService.searchBy(name, surname, email), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
	public ResponseEntity<?> getUserInfo(@PathVariable Integer id) {
		try {
			User userById = userService.getById(id);
			return new ResponseEntity<>(userById, HttpStatus.OK);
		} catch (NuSuchUserException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
	public ResponseEntity<?> updateInfo(@PathVariable Integer id, @RequestBody User user) {
		try {
			userService.updateUser(id, user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NuSuchUserException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
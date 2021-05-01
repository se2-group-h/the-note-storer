package com.notes.backend.controllers;

import com.notes.backend.dao.UserRepository;
import com.notes.backend.entities.AuthorizedUser;
import com.notes.backend.entities.LoginForm;
import com.notes.backend.entities.User;
import com.notes.backend.exceptions.BadCredentialsException;
import com.notes.backend.services.AuthService;
import com.notes.backend.services.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Login")
@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> test() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> signIn(@RequestBody LoginForm credentials) {
        try {
            AuthorizedUser authentication = authService.trySignIn(credentials);
            return new ResponseEntity<>(authentication, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Bad credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
package com.notes.backend.controllers;

import com.notes.backend.entities.AuthorizedUser;
import com.notes.backend.entities.LoginForm;
import com.notes.backend.exceptions.BadCredentialsException;
import com.notes.backend.services.AuthService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "Login")
@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class AuthController {

    private final AuthService authService;

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
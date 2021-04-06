package com.notes.backend.controllers;

import com.notes.backend.entities.User;
import com.notes.backend.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/signup")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody User user) {
        boolean isValid = registrationService.validateUser(user);
        if (isValid) {
            User savedUser = registrationService.saveNewUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid form", HttpStatus.BAD_REQUEST);
        }
    }

}

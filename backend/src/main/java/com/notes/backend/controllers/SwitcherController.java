package com.notes.backend.controllers;

import com.notes.backend.configs.SecuritySwitcher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Authentication Switcher")
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class SwitcherController {

    private SecuritySwitcher securitySwitcher;

    @GetMapping("/{value}")
    public ResponseEntity<String> toggleAuthorization(@ApiParam(value = "State: on/off", example = "off", required = true) @PathVariable(name = "value") String value) {
        if (value.equals("on")) {
            securitySwitcher.setEnabled(true);
            return new ResponseEntity<>("Security turned on.", HttpStatus.OK);
        } else if (value.equals("off")) {
            securitySwitcher.setEnabled(false);
            return new ResponseEntity<>("Security turned off.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bad value of security state.", HttpStatus.BAD_REQUEST);
        }
    }
}

package com.notes.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "JWT Testing")
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @GetMapping
    @ApiImplicitParam(name = "Authorization", paramType = "header", example = "Bearer $JWT", dataTypeClass = String.class)
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Resource accessed", HttpStatus.OK);
    }
}

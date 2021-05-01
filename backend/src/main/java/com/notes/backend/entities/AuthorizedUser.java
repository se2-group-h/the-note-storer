package com.notes.backend.entities;

import lombok.Data;

import java.util.List;

@Data
public class AuthorizedUser {
    private Integer userId;
    private String firstName;
    private String token;
    private List<Recipe> recipeList;
}

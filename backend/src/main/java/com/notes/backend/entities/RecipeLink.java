package com.notes.backend.entities;

import lombok.Data;

@Data
public class RecipeLink {
    private Integer userId;
    private Integer recipeId;
}

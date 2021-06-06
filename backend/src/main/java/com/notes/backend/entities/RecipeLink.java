package com.notes.backend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
public class RecipeLink {

    private Integer userId;
    private Integer recipeId;

    public RecipeLink(Integer userId, Integer recipeId) {

    }
}

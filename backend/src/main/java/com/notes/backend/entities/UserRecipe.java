package com.notes.backend.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_recipe")
public class UserRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_recipe_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="recipe_id", nullable=false)
    private Recipe recipe;

    @Override
    public String toString() {
        return "UserRecipe{" +
                "user=" + user.getUserId() +
                ", recipe=" + recipe.getRecipeId() +
                '}';
    }

    @JsonProperty
    public Integer getUser() {
        return user.getUserId();
    }

    @JsonProperty
    public Integer getRecipe() {
        return recipe.getRecipeId();
    }

    @JsonIgnore
    public Recipe getNormalRecipe() {
        return recipe;
    }
}

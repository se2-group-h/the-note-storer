package com.notes.backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private Collection<? extends GrantedAuthority> authorities;
    private List<Recipe> recipeList;

    public UserDetailsImpl(Integer id, String firstName, String login, String password, List<Recipe> recipes) {
        this.id = id;
        this.firstName = firstName;
        this.username = login;
        this.password = password;
        this.recipeList = recipes;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getUserId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getSavedRecipes().stream().map(UserRecipe::getNormalRecipe).collect(toList()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
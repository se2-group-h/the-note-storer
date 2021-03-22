package com.notes.backend.entities;

import lombok.Data;

@Data
public class AuthorizedUser {
    private Integer userId;
    private String firstName;
    private String token;
}

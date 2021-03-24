package com.notes.backend.services;

import com.notes.backend.entities.AuthorizedUser;
import com.notes.backend.entities.LoginForm;
import com.notes.backend.entities.UserDetailsImpl;
import com.notes.backend.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    private Authentication setAuthentication(LoginForm credentials) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authentication;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public AuthorizedUser trySignIn(LoginForm credentials) throws Exception {
        AuthorizedUser authorizedUser = new AuthorizedUser();
        Authentication authentication = setAuthentication(credentials);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        authorizedUser.setUserId(userDetails.getId());
        authorizedUser.setFirstName(userDetails.getFirstName());
        authorizedUser.setToken(jwtUtils.generateJwtToken(authentication));

        return authorizedUser;
    }
}

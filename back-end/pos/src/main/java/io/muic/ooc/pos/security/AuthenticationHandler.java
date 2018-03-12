package io.muic.ooc.pos.security;

import io.muic.ooc.pos.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AuthenticationHandler implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Check with Database

        if (userService.authenticate(username, password)){
            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        }
        return null;


    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

package com.example.emillab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomUserDetailsManager customUserDetailsManager;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("hello from the other side");
        String username = (String) authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = customUserDetailsManager.loadUserByUsername(username);
        if(userDetails.getPassword().equals(password)){
            return new UsernamePasswordAuthenticationToken(
                    username, password, List.of((GrantedAuthority) () -> "ROLE_ADMIN"));
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}

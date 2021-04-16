package com.example.emillab.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

            if(token!=null){
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor("test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123test123".getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            Object username = (String) claims.get("username");
            var auth = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    List.of((GrantedAuthority) () -> "ROLE_ADMIN"));
            SecurityContextHolder.getContext()
                    .setAuthentication(auth);

        }
        filterChain.doFilter(request,response);
    }
}

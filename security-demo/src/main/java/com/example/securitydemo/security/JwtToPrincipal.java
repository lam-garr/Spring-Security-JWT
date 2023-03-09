package com.example.securitydemo.security;

import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtToPrincipal {
    
    public UserPrincipal convert(DecodedJWT jwt){
        return UserPrincipal.builder()
            .userId(Integer.valueOf(jwt.getSubject()))
            .username(jwt.getClaim("username").asString())
            .build();
    }
}

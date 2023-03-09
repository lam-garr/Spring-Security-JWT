package com.example.securitydemo.security;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtIssuer {
    
    public String issue(int userId, String username){
        return JWT.create()
            .withSubject(String.valueOf(userId))
            .withClaim("username", username)
            .withExpiresAt(Instant.now().plus(Duration.of(1,ChronoUnit.DAYS)))
            .sign(Algorithm.HMAC256("secret"));
    }
}

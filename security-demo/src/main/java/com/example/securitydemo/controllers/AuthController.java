package com.example.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitydemo.models.LoginReq;
import com.example.securitydemo.models.LoginRes;
import com.example.securitydemo.security.JwtIssuer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;
    
    @PostMapping("/login")
    public LoginRes login(@RequestBody LoginReq req){

        var token = jwtIssuer.issue(69420, "Goku");

        return LoginRes.builder()
            .accessToken(token)
            .build();
    }

    @GetMapping("/secure")
    public String secure(){
        return "OK!";
    }
}

package com.example.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitydemo.models.LoginReq;
import com.example.securitydemo.models.LoginRes;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
    
    @PostMapping("/login")
    public LoginRes login(@RequestBody LoginReq req){
        return LoginRes.builder()
            .accessToken("accessToken")
            .build();
    }
}

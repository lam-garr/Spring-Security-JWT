package com.example.securitydemo.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitydemo.models.LoginReq;
import com.example.securitydemo.models.LoginRes;
import com.example.securitydemo.security.JwtIssuer;
import com.example.securitydemo.security.UserPrincipal;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;
    
    @GetMapping("/login")
    public LoginRes login(){
        //@RequestBody LoginReq req
        var authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken("Goku", "password")
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var principal = (UserPrincipal) authentication.getPrincipal();

        var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername());

        return LoginRes.builder()
            .accessToken(token)
            .build();
    }

    @GetMapping("/secure")
    public String secure(@AuthenticationPrincipal UserPrincipal principal){
        return "OK! " + principal.getUserId();
    }
}


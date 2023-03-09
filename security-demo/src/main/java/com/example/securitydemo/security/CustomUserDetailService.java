package com.example.securitydemo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.securitydemo.services.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var user = userService.findByUsername(username).orElseThrow();

        return UserPrincipal.builder()
            .userId(user.getId())
            .username(user.getUsername())
            .password(user.getPassword())
            .build();
    }
    
}

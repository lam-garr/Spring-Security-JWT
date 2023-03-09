package com.example.securitydemo.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securitydemo.entity.UserEntity;

@Service
public class UserService {

    private static final String EXIST_NAME = "Goku";
    
    public Optional<UserEntity> findByUsername(String username){
        if(!EXIST_NAME.equalsIgnoreCase(username)) return Optional.empty();

        var user = new UserEntity();

        user.setId(696969);
        user.setUsername(EXIST_NAME);
        user.setPassword(new BCryptPasswordEncoder().encode("password"));
        return Optional.of(user);
    }
}

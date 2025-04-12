package com.clothingCart.clothingCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clothingCart.clothingCart.model.User;
import com.clothingCart.clothingCart.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Register a new user
    public void registerUser(String username, String password) {
        if (userRepository.existsById(username)) {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));  // Encrypt password
        userRepository.save(user);
    }

    // Authenticate user
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && bCryptPasswordEncoder.matches(password, user.getPassword());
    }
}

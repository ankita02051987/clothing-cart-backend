package com.clothingCart.clothingCart.service;

import com.clothingCart.clothingCart.dto.UserRegisterRequest;
import com.clothingCart.clothingCart.dto.UserRequest;
import com.clothingCart.clothingCart.exception.InvalidPasswordException;
import com.clothingCart.clothingCart.exception.UserAlreadyExistsException;
import com.clothingCart.clothingCart.exception.UserNotFoundException;
import com.clothingCart.clothingCart.model.User;
import com.clothingCart.clothingCart.repository.UserRepository;
import com.clothingCart.clothingCart.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    // Register a new user
    public User register(UserRegisterRequest registerRequest) {
        Optional<User> userOptional = userRepository.findByEmail(registerRequest.getEmail());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User Already Exists with this Email!");
        }
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        return userRepository.save(user);
    }

    // Login user
    public String login(UserRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(request.getPassword())) {
                // Generate token with userId
                return jwtUtil.generateToken(user.getEmail(), user.getId()); // Pass userId
            } else {
                throw new InvalidPasswordException("Incorrect password");
            }
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}


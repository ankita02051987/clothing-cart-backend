//package com.clothingCart.clothingCart.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.clothingCart.clothingCart.service.AuthService;
//import com.clothingCart.clothingCart.util.JwtUtil;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/register")
//    public String register(@RequestParam String username, @RequestParam String password) {
//        authService.registerUser(username, password);
//        return "User registered successfully";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        if (authService.authenticateUser(username, password)) {
//            return JwtUtil.generateToken(username);  // Return JWT token
//        } else {
//            throw new RuntimeException("Invalid credentials");
//        }
//    }
//}

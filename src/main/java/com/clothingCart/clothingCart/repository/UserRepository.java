package com.clothingCart.clothingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothingCart.clothingCart.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}

package com.clothingCart.clothingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothingCart.clothingCart.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

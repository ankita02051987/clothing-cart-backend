package com.clothingCart.clothingCart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private String username;
    private String password;

    // Getters and Setters
}

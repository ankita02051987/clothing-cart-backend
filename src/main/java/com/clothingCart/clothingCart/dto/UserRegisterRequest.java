package com.clothingCart.clothingCart.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotBlank(message = "First name is required.")
    private String firstName;
    @NotBlank(message = "Last name is required.")
    private String lastName;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Email should be a valid address (e.g., example@mail.com)")
    private String email;
    @NotBlank(message = "Password is required.")
    @NotEmpty(message = "Password can't be empty")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters.")
    @Pattern(regexp = ".*[!@#$%^&*()_+{}|:<>?].*", message = "Password must contain at least 1 special character.")
    @Pattern(regexp = ".*[0-9].*", message = "Password must contain at least 1 number.")
    private String password;
}

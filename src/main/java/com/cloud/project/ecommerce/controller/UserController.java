package com.cloud.project.ecommerce.controller;

import com.cloud.project.ecommerce.model.User;
import com.cloud.project.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // create user rest API
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user)  {
        int rowsAffected = userRepository.register(user);
        return (rowsAffected > 0) ? ResponseEntity.ok("User successfully registered!")
                : ResponseEntity.internalServerError().build();
    }

    // login user rest API
    @PutMapping("/login/{id}")
    public ResponseEntity<?> loginUser(@PathVariable Long id) {

        int rowsAffected = userRepository.login(id);
        return (rowsAffected > 0) ? ResponseEntity.ok("Login successful!")
                : ResponseEntity.internalServerError().build();
    }
}

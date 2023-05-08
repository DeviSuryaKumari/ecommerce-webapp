/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.controller;

import com.cloud.project.ecommerce.model.LoginRequest;
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
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user)  {
        int rowsAffected = userRepository.register(user);
        return (rowsAffected > 0) ? ResponseEntity.ok("User successfully registered!")
                : ResponseEntity.internalServerError().build();
    }

    // login user rest API
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {

        User user = userRepository.fetchUser(loginRequest.getUserId());

        if (!user.getPassword().equals(loginRequest.getPassword()) || !user.getUsername().equals(loginRequest.getUsername())) {
            return ResponseEntity.internalServerError().body("Login failed due to incorrect credentials");
        }
        int rowsAffected = userRepository.login(loginRequest.getUserId());
        return (rowsAffected > 0) ? ResponseEntity.ok("Login successful!")
                : ResponseEntity.internalServerError().build();
    }

    @CrossOrigin
    @PutMapping("/logout/{id}")
    public ResponseEntity<?> logoutUser(@PathVariable Integer id) {

        int rowsAffected = userRepository.logout(id);
        return (rowsAffected > 0) ? ResponseEntity.ok("Logout successful!")
                : ResponseEntity.internalServerError().build();
    }
}

package com.srgec.Notes_Management.controller;

import org.springframework.web.bind.annotation.*;

import com.srgec.Notes_Management.dto.LoginRequest;
import com.srgec.Notes_Management.model.User;
import com.srgec.Notes_Management.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest login)
            throws Exception {
        return service.login(
                login.getEmail(),
                login.getPassword()
        );
    }
}
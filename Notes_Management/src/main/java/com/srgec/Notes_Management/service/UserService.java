package com.srgec.Notes_Management.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.srgec.Notes_Management.config.JwtService;
import com.srgec.Notes_Management.exceptions.UserNotFoundException;
import com.srgec.Notes_Management.model.User;
import com.srgec.Notes_Management.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public UserService(UserRepository repository, PasswordEncoder encoder, JwtService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public User registerUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    public String login(String email, String password)
            throws UserNotFoundException {

        Optional<User> foundUser = repository.findByEmail(email);

        if (!foundUser.isPresent()) {
            throw new UserNotFoundException();
        }

        User user = foundUser.get();

        boolean matches = encoder.matches(
                password,
                user.getPassword());

        if (!matches) {
            throw new RuntimeException("Password Incorrect");
        }

        return jwtService.generateToken(email);
    }
}
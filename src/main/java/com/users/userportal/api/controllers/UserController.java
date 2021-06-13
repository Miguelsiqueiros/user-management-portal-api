package com.users.userportal.api.controllers;

import com.users.userportal.core.entities.User;
import com.users.userportal.infrastructure.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/byId/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") Integer id) {
        var user = userRepository.findById(id);

        if(user.isEmpty()) {
            logger.error(String.format("User with id: %s not found", id));

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        } else {
            return user;
        }
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public int createUser(@Valid @RequestBody User user) {
        return userRepository.save(user).getId();
    }

    @DeleteMapping("/users/byId{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id")Integer id) {
        var user = userRepository.findById(id);

        if(user.isEmpty()) {
            logger.error(String.format("User with id: %s not found", id));

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        } else {
            userRepository.deleteById(id);
        }
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@Valid @RequestBody User updatedUser) {
        userRepository.save(updatedUser);
    }
}
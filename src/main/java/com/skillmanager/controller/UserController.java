package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.skillmanager.dto.UserDTO;
import com.skillmanager.entity.User;
import com.skillmanager.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO saveUser(@Valid @RequestBody User user) {

        User saved = userService.saveUser(user);

        return userService.getUserById(saved.getId());
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {

        UserDTO dto = userService.getUserById(id);

        return dto;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id,
                              @Valid @RequestBody User user) {
    	
        return userService.updateUser(id, user);
    }
}
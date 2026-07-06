package com.skillmanager.service;

import java.util.List;

import com.skillmanager.dto.UserDTO;
import com.skillmanager.entity.User;

public interface UserService {

    User saveUser(User user);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, User user);

    void deleteUser(Long id);
}
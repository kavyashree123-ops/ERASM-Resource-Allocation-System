package com.skillmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.skillmanager.dto.UserDTO;
import com.skillmanager.entity.Role;
import com.skillmanager.entity.User;
import com.skillmanager.repository.RoleRepository;
import com.skillmanager.repository.UserRepository;
import com.skillmanager.service.AuditLogService;
import com.skillmanager.service.UserService;
import com.skillmanager.util.SecurityUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuditLogService auditLogService;
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        auditLogService.log(
                "CREATE",
                "User",
                savedUser.getId(),
                SecurityUtil.getCurrentUser());

        return savedUser;
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole().getRoleName()))
                .toList();
    }

    @Override
    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().getRoleName());
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

        auditLogService.log(
                "DELETE",
                "User",
                id,
                SecurityUtil.getCurrentUser());
    }
    @Override
    public UserDTO updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findById(user.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        existingUser.setRole(role);

        User updatedUser = userRepository.save(existingUser);

        auditLogService.log(
                "UPDATE",
                "User",
                updatedUser.getId(),
                SecurityUtil.getCurrentUser());


        return new UserDTO(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getRole().getRoleName());
    }
}
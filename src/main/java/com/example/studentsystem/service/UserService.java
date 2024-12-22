package com.example.studentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.UserRepository;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Injecting the UserRepository instance

    public User authenticateUser(String username, String password) {
        // Use the injected instance of UserRepository to call findByUsername
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username"));

        if (!password.equals(user.getPassword())) { // Plain text password check
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

    public List<User> getAllUsers() {
        // Use the injected instance of UserRepository to call findAll
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        // Use the injected instance of UserRepository to call findById
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User addUser(User user) {
        // Use the injected instance of UserRepository to save the user
        return userRepository.save(user);
    }

    public User updateUser(int id, User userDetails) {
        // Use the injected instance of UserRepository to update the user
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword()); // Plain text password storage
        user.setRole(userDetails.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        // Use the injected instance of UserRepository to delete a user
        userRepository.deleteById(id);
    }
}

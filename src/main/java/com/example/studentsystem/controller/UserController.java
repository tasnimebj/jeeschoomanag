package com.example.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.User;
import com.example.studentsystem.service.UserService;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping
    public List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(UserService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(UserService.addUser(user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        System.out.println("Received user update request: " + user);
        return ResponseEntity.ok(UserService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginDetails) {
        try {
            User user = UserService.authenticateUser(loginDetails.getUsername(), loginDetails.getPassword());
            return ResponseEntity.ok(user);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(401).body(null); // Unauthorized response if authentication fails
        }
    }
}

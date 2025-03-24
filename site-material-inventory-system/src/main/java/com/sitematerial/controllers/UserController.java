package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.User;
import com.sitematerial.services.UserServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("Creating user with email: {}", user.getEmail());
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Fetching all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        logger.info("Fetching user by ID: {}", id);
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        logger.info("Deleting user with ID: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUserRole(@PathVariable Integer id,
                                                 @RequestBody Map<String, String> requestBody) {
        logger.info("User role change by ID: {}", id);
        String rolename = requestBody.get("rolename");

        User u = userService.updateuserRole(id, rolename);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not updated");
        }
        return ResponseEntity.ok("User updated successfully");
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<String> updateUserRole(@PathVariable Integer id,
//                                                 @RequestBody String roleName) {
//        logger.info("User role change by ID: {}", id);
////        String rolename = requestBody.get("rolename");
//
//        User u = userService.updateuserRole(id, roleName);
//        if (u == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not updated");
//        }
//        return ResponseEntity.ok("User updated successfully");
//    }
}
package com.sitematerial.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.Role;
import com.sitematerial.services.RoleServiceImpl;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin("*")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        logger.info("Creating role: {}", role.getRoleName());
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        logger.info("Fetching all roles");
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        logger.info("Fetching role by ID: {}", id);
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Integer id) {
        logger.info("Deleting role with ID: {}", id);
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role deleted successfully");
    }
}
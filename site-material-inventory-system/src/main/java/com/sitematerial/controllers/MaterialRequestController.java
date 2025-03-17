package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.MaterialRequest;
import com.sitematerial.services.IMaterialRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/material-requests")
public class MaterialRequestController {

    private static final Logger logger = LoggerFactory.getLogger(MaterialRequestController.class);

    @Autowired
    private IMaterialRequestService requestService;

    @PostMapping
    public ResponseEntity<MaterialRequest> createRequest(@RequestBody MaterialRequest request) {
        logger.info("Creating material request");
        return ResponseEntity.ok(requestService.createRequest(request));
    }

    @GetMapping
    public ResponseEntity<List<MaterialRequest>> getAllRequests() {
        logger.info("Fetching all material requests");
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialRequest> getRequestById(@PathVariable Integer id) {
        logger.info("Fetching material request by ID: {}", id);
        return ResponseEntity.ok(requestService.getRequestById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Integer id) {
        logger.info("Deleting material request with ID: {}", id);
        requestService.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully");
    }
}

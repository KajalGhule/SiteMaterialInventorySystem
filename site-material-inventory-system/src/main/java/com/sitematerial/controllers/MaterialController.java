package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.Material;
import com.sitematerial.services.IMaterialService;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
@CrossOrigin(origins = "*")
public class MaterialController {
	
	private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private IMaterialService materialService;

    @PostMapping("/add")
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        logger.info("Creating new material with name: {}", material.getMaterialName());
        Material saved = materialService.addMaterial(material);
        logger.info("Material created with ID: {}", saved.getMaterialID());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer id) {
        logger.info("Fetching material with ID: {}", id);
        Material found = materialService.getMaterialById(id);
        if (found == null) {
            logger.warn("Material with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
        logger.info("Material found: {}", found.getMaterialName());
        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Integer id, @RequestBody Material updatedMaterial) {
    	logger.info("Updating material with name: {}", updatedMaterial.getMaterialName());
        Material updated = materialService.updateMaterial(id, updatedMaterial);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaterial(@PathVariable Integer id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.ok("Material with ID " + id + " deleted successfully.");
    }
}

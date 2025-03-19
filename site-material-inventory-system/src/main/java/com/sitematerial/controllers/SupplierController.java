package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.Supplier;
import com.sitematerial.services.ISupplierService;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private ISupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        logger.info("Creating new supplier: {}", supplier.getSupplierName());
        return ResponseEntity.ok(supplierService.createSupplier(supplier));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        logger.info("Fetching all suppliers");
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer id) {
        logger.info("Fetching supplier with ID: {}", id);
        Supplier supplier = supplierService.getSupplierById(id);
        return supplier != null ? ResponseEntity.ok(supplier) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier) {
        logger.info("Updating supplier with ID: {}", id);
        Supplier updated = supplierService.updateSupplier(id, supplier);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        logger.info("Deleting supplier with ID: {}", id);
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}

package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.Approval;
import com.sitematerial.services.IApprovalService;

import java.util.List;

@RestController
@RequestMapping("/api/approvals")
@CrossOrigin("*")
public class ApprovalController {

    private static final Logger logger = LoggerFactory.getLogger(ApprovalController.class);

    @Autowired
    private IApprovalService approvalService;

    @PostMapping
    public ResponseEntity<Approval> createApproval(@RequestBody Approval approval) {
        logger.info("Creating approval for request ID: {}", approval.getRequest().getrequestID());
        return ResponseEntity.ok(approvalService.createApproval(approval));
    }

    @GetMapping
    public ResponseEntity<List<Approval>> getAllApprovals() {
        logger.info("Fetching all approvals");
        return ResponseEntity.ok(approvalService.getAllApprovals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Integer id) {
        logger.info("Fetching approval by ID: {}", id);
        return ResponseEntity.ok(approvalService.getApprovalById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApproval(@PathVariable Integer id) {
        logger.info("Deleting approval with ID: {}", id);
        approvalService.deleteApproval(id);
        return ResponseEntity.ok("Approval deleted successfully");
    }
}

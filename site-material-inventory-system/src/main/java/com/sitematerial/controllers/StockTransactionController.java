package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.StockTransaction;
import com.sitematerial.services.IStockTransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class StockTransactionController {

    private static final Logger logger = LoggerFactory.getLogger(StockTransactionController.class);

    @Autowired
    private IStockTransactionService transactionService;

    @PostMapping
    public ResponseEntity<StockTransaction> createTransaction(@RequestBody StockTransaction transaction) {
        logger.info("Creating stock transaction for material ID: {}", transaction.getMaterial().getMaterialID());
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<List<StockTransaction>> getAllTransactions() {
        logger.info("Fetching all stock transactions");
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockTransaction> getTransactionById(@PathVariable Integer id) {
        logger.info("Fetching stock transaction by ID: {}", id);
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Integer id) {
        logger.info("Deleting stock transaction with ID: {}", id);
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}

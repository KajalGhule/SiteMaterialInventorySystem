package com.sitematerial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.entities.StockTransaction;
import com.sitematerial.repositories.StockTransactionRepository;

import java.util.List;

@Service
public class StockTransactionServiceImpl implements IStockTransactionService {

    @Autowired
    private StockTransactionRepository transactionRepository;

    @Override
    public StockTransaction createTransaction(StockTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<StockTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public StockTransaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}
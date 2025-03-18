package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitematerial.entities.StockTransaction;

public interface StockTransactionRepository extends JpaRepository<StockTransaction, Integer> {
}
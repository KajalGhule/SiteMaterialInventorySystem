package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.StockTransaction;

public interface IStockTransactionService {
		StockTransaction createTransaction(StockTransaction transaction);
	    List<StockTransaction> getAllTransactions();
	    StockTransaction getTransactionById(Integer id);
	    void deleteTransaction(Integer id);
}

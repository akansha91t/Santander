package com.santander.demo.service;

import java.util.List;
import java.util.Optional;

import com.santander.demo.model.Transaction;

public interface TransactionService {

	
	Transaction createTransaction(Transaction transaction);

	List<Transaction> getAllTransaction();

	Optional<Transaction> getTransactionBySender(String sender);
}

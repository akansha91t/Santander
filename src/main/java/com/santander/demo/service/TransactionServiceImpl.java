package com.santander.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santander.demo.model.Transaction;
import com.santander.demo.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private TransactionRepository transactionRepository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransaction() {
		return this.transactionRepository.findAll();
	}

	@Override
	public Optional<Transaction> getTransactionBySender(String sender) {
		
		return Optional.of(this.transactionRepository.findBySender(sender));

	}

}

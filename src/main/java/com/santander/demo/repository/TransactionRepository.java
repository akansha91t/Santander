package com.santander.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.demo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	Transaction findBySender(String sender);

}

package com.santander.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santander.demo.exception.ResourceNotFoundException;
import com.santander.demo.model.Transaction;
import com.santander.demo.service.TransactionServiceImpl;

@RestController
@RequestMapping("/api")
public class TransactionController {
	@Autowired
	private TransactionServiceImpl transactionService;
	
	private static final Logger log = LoggerFactory.getLogger(TransactionController.class);


	@GetMapping("/transactions/{sender}")
	public ResponseEntity<Transaction> getTransactionBySender(@PathVariable String sender)
			throws ResourceNotFoundException {
		Transaction transaction = transactionService.getTransactionBySender(sender)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this Sender :: " + sender));
		return ResponseEntity.ok().body(transaction);
	}

	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllProduct() {
		return ResponseEntity.ok().body(transactionService.getAllTransaction());
	}

	@PostMapping("/transaction")
	public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
		String url = "https://www.uuidgenerator.net/api/version4";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class, 1);

		if (response.getStatusCode() == HttpStatus.OK) {
			log.debug(response.getBody());
			transaction.setId(response.getBody());
		}
		else
			log.error(url +" giving " +response.getStatusCode());
			
		return ResponseEntity.ok().body(this.transactionService.createTransaction(transaction));
	}
}
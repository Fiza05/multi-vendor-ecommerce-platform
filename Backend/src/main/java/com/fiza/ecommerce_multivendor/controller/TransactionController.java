package com.fiza.ecommerce_multivendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.Transaction;
import com.fiza.ecommerce_multivendor.service.SellerService;
import com.fiza.ecommerce_multivendor.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	private final TransactionService transactionService;
	private final SellerService sellerService;

	@Autowired
	public TransactionController(TransactionService transactionService,
			SellerService sellerService) {
		this.transactionService = transactionService;
		this.sellerService = sellerService;
	}

	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody Order order) {
		Transaction transaction = transactionService.createTransaction(order);
		return ResponseEntity.ok(transaction);
	}

	@GetMapping("/seller")
	public ResponseEntity<List<Transaction>> getTransactionBySeller(
			@RequestHeader("Authorization") String jwt) throws SellerException {
		Seller seller = sellerService.getSellerProfile(jwt);

		List<Transaction> transactions = transactionService.getTransactionBySeller(seller);
		return ResponseEntity.ok(transactions);
	}

	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		List<Transaction> transactions = transactionService.getAllTransactions();
		return ResponseEntity.ok(transactions);
	}
}

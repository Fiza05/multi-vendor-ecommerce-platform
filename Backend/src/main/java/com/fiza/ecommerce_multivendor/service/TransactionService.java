package com.fiza.ecommerce_multivendor.service;

import java.util.List;

import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.Transaction;

public interface TransactionService {

    Transaction createTransaction(Order order);

    List<Transaction> getTransactionBySeller(Seller seller);

    List<Transaction> getAllTransactions();
}

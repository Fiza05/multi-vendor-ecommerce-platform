package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.Transaction;
import com.fiza.ecommerce_multivendor.model.User;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Order order);

    List<Transaction> getTransactionBySeller(Seller seller);

    List<Transaction> getAllTransactions();
}

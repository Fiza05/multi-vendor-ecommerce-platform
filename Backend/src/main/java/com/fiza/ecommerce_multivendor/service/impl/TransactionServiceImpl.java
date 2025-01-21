package com.fiza.ecommerce_multivendor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.Transaction;
import com.fiza.ecommerce_multivendor.repository.SellerRepository;
import com.fiza.ecommerce_multivendor.repository.TransactionRepository;
import com.fiza.ecommerce_multivendor.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
            SellerRepository sellerRepository) {
        this.transactionRepository = transactionRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Transaction createTransaction(Order order) {
        Seller seller = sellerRepository.findById(order.getSellerId()).get();
        Transaction transaction = new Transaction();
        transaction.setCustomer(order.getUser());
        transaction.setOrder(order);
        transaction.setSeller(seller);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionBySeller(Seller seller) {
        return transactionRepository.findBySellerId(seller.getId());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}

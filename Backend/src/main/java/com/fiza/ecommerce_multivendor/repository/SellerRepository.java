package com.fiza.ecommerce_multivendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.domain.AccountStatus;
import com.fiza.ecommerce_multivendor.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByEmail(String email);

    List<Seller> findByAccountStatus(AccountStatus status);
}

package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.domain.AccountStatus;
import com.fiza.ecommerce_multivendor.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByEmail(String email);

    List<Seller> findByAccountStatus(AccountStatus status);
}

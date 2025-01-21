package com.fiza.ecommerce_multivendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.domain.PayoutsStatus;
import com.fiza.ecommerce_multivendor.model.Payouts;

public interface PayoutsRepository extends JpaRepository<Payouts, Long> {

    List<Payouts> findPayoutsBySellerId(Long sellerId);

    List<Payouts> findAllByStatus(PayoutsStatus status);
}

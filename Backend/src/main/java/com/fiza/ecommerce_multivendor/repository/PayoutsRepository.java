package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.domain.PayoutsStatus;
import com.fiza.ecommerce_multivendor.model.Payouts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayoutsRepository extends JpaRepository<Payouts, Long> {

    List<Payouts> findPayoutsBySellerId(Long sellerId);

    List<Payouts> findAllByStatus(PayoutsStatus status);
}

package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {

    PaymentOrder findByPaymentLinkId(String paymentId);
}

package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String couponCode);
}

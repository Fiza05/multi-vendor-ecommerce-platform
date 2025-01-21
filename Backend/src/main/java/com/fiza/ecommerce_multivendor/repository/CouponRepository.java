package com.fiza.ecommerce_multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String couponCode);
}

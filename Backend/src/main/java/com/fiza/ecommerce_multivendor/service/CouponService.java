package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.Coupon;
import com.fiza.ecommerce_multivendor.model.User;

import java.util.List;
import java.util.Optional;

public interface CouponService {
    Cart applyCoupon(String code, double orderValue, User user) throws Exception;

    Cart removeCoupon(String code, User user) throws Exception;

    Coupon createCoupon(Coupon coupon);

    void deleteCoupon(Long couponId);

    List<Coupon> getAllCoupons();

    Coupon getCouponById(Long couponId);
}

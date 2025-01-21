package com.fiza.ecommerce_multivendor.service;

import java.util.List;

import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.Coupon;
import com.fiza.ecommerce_multivendor.model.User;

public interface CouponService {
    Cart applyCoupon(String code, double orderValue, User user) throws Exception;

    Cart removeCoupon(String code, User user) throws Exception;

    Coupon createCoupon(Coupon coupon);

    void deleteCoupon(Long couponId);

    List<Coupon> getAllCoupons();

    Coupon getCouponById(Long couponId);
}

package com.fiza.ecommerce_multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Wishlist findByUserId(Long userId);
}

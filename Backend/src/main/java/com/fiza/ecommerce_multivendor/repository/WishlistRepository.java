package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Wishlist findByUserId(Long userId);
}

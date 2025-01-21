package com.fiza.ecommerce_multivendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByUserId(Long userId);

    List<Review> findReviewsByProductId(Long productId);
}

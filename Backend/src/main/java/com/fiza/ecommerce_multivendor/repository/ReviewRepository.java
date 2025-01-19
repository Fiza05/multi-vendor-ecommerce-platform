package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.Review;
import com.fiza.ecommerce_multivendor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByUserId(Long userId);

    List<Review> findReviewsByProductId(Long productId);
}

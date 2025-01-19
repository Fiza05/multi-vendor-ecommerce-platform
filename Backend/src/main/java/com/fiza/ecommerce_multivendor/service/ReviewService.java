package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.exception.ReviewNotFoundException;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.Review;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.request.CreateReviewRequest;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ReviewService {

    Review createReview(CreateReviewRequest req,
            User user,
            Product product);

    List<Review> getReviewsByProductId(Long productId);

    Review updateReview(Long reviewId,
            String reviewText,
            double rating,
            Long userId) throws ReviewNotFoundException, AuthenticationException;

    void deleteReview(Long reviewId, Long userId) throws ReviewNotFoundException, AuthenticationException;

}

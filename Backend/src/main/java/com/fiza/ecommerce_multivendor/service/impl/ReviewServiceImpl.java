package com.fiza.ecommerce_multivendor.service.impl;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.stereotype.Service;

import com.fiza.ecommerce_multivendor.exception.ReviewNotFoundException;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.Review;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.repository.ReviewRepository;
import com.fiza.ecommerce_multivendor.request.CreateReviewRequest;
import com.fiza.ecommerce_multivendor.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(CreateReviewRequest req, User user, Product product) {
        Review newReview = new Review();

        newReview.setReviewText(req.getReviewText());
        newReview.setRating(req.getReviewRating());
        newReview.setProductImages(req.getProductImages());
        newReview.setUser(user);
        newReview.setProduct(product);

        product.getReviews().add(newReview);

        return reviewRepository.save(newReview);
    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findReviewsByProductId(productId);
    }

    @Override
    public Review updateReview(Long reviewId, String reviewText, double rating, Long userId)
            throws ReviewNotFoundException, AuthenticationException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review Not found"));

        if (review.getUser().getId() != userId) {
            throw new AuthenticationException("You do not have permission to delete this review");
        }

        review.setReviewText(reviewText);
        review.setRating(rating);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId, Long userId)
            throws ReviewNotFoundException, AuthenticationException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review Not found"));
        if (review.getUser().getId() != userId) {
            throw new AuthenticationException("You do not have permission to delete this review");
        }
        reviewRepository.delete(review);
    }

}

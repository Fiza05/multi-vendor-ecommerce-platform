package com.fiza.ecommerce_multivendor.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.exception.ProductException;
import com.fiza.ecommerce_multivendor.exception.ReviewNotFoundException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.Review;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.request.CreateReviewRequest;
import com.fiza.ecommerce_multivendor.response.ApiResponse;
import com.fiza.ecommerce_multivendor.service.ProductService;
import com.fiza.ecommerce_multivendor.service.ReviewService;
import com.fiza.ecommerce_multivendor.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/products/{productId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Long productId) {

        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);

    }

    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity<Review> writeReview(@RequestBody CreateReviewRequest req,
            @PathVariable Long productId, @RequestHeader("Authorization") String jwt)
            throws UserException, ProductException {

        User user = userService.findUserProfileByJwt(jwt);
        Product product = productService.findProductById(productId);

        Review review = reviewService.createReview(req, user, product);
        return ResponseEntity.ok(review);

    }

    @PatchMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@RequestBody CreateReviewRequest req,
            @PathVariable Long reviewId, @RequestHeader("Authorization") String jwt)
            throws UserException, ReviewNotFoundException, AuthenticationException {

        User user = userService.findUserProfileByJwt(jwt);

        Review review = reviewService.updateReview(reviewId, req.getReviewText(),
                req.getReviewRating(), user.getId());
        return ResponseEntity.ok(review);

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<ApiResponse> deleteReview(@PathVariable Long reviewId,
            @RequestHeader("Authorization") String jwt)
            throws UserException, ReviewNotFoundException, AuthenticationException {

        User user = userService.findUserProfileByJwt(jwt);

        reviewService.deleteReview(reviewId, user.getId());
        ApiResponse res = new ApiResponse();
        res.setMessage("Review deleted successfully");
        res.setStatus(true);

        return ResponseEntity.ok(res);

    }
}

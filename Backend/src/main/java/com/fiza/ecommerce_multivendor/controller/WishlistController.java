package com.fiza.ecommerce_multivendor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.exception.ProductException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.exception.WishlistNotFoundException;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.model.Wishlist;
import com.fiza.ecommerce_multivendor.service.ProductService;
import com.fiza.ecommerce_multivendor.service.UserService;
import com.fiza.ecommerce_multivendor.service.WishlistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishlistController {

	private final WishlistService wishlistService;
	private final ProductService productService;
	private final UserService userService;

	@PostMapping("/create")
	public ResponseEntity<Wishlist> createWishlist(@RequestBody User user) {
		Wishlist wishlist = wishlistService.createWishlist(user);
		return ResponseEntity.ok(wishlist);
	}

	@GetMapping()
	public ResponseEntity<Wishlist> getWishlistByUserId(@RequestHeader("Authorization") String jwt)
			throws UserException {

		User user = userService.findUserProfileByJwt(jwt);
		Wishlist wishlist = wishlistService.getWishlistByUserId(user);
		return ResponseEntity.ok(wishlist);
	}

	@PostMapping("/add-product/{productId}")
	public ResponseEntity<Wishlist> addProductToWishlist(@PathVariable Long productId,
			@RequestHeader("Authorization") String jwt)
			throws WishlistNotFoundException, ProductException, UserException {

		Product product = productService.findProductById(productId);
		User user = userService.findUserProfileByJwt(jwt);
		Wishlist updatedWishlist = wishlistService.addProductToWishlist(user, product);
		return ResponseEntity.ok(updatedWishlist);

	}

}

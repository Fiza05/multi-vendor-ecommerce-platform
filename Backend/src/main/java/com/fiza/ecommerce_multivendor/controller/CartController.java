package com.fiza.ecommerce_multivendor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.exception.CartItemException;
import com.fiza.ecommerce_multivendor.exception.ProductException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.CartItem;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.request.AddItemRequest;
import com.fiza.ecommerce_multivendor.response.ApiResponse;
import com.fiza.ecommerce_multivendor.service.CartItemService;
import com.fiza.ecommerce_multivendor.service.CartService;
import com.fiza.ecommerce_multivendor.service.ProductService;
import com.fiza.ecommerce_multivendor.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;
	private final UserService userService;
	private final ProductService productService;
	private final CartItemService cartItemService;

	@GetMapping
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt)
			throws UserException {

		User user = userService.findUserProfileByJwt(jwt);

		Cart cart = cartService.findUserCart(user);

		System.out.println("cart - " + cart.getUser().getEmail());

		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException {

		User user = userService.findUserProfileByJwt(jwt);
		Product product = productService.findProductById(req.getProductId());

		CartItem item = cartService.addCartItem(user, product, req.getSize(), req.getQuantity());

		return new ResponseEntity<>(item, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/item/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItemHandler(@PathVariable Long cartItemId,
			@RequestHeader("Authorization") String jwt) throws CartItemException, UserException {

		User user = userService.findUserProfileByJwt(jwt);
		cartItemService.removeCartItem(user.getId(), cartItemId);

		ApiResponse res = new ApiResponse("Item Remove From Cart", true);

		return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
	}

	@PutMapping("/item/{cartItemId}")
	public ResponseEntity<CartItem> updateCartItemHandler(@PathVariable Long cartItemId,
			@RequestBody CartItem cartItem, @RequestHeader("Authorization") String jwt)
			throws CartItemException, UserException {

		User user = userService.findUserProfileByJwt(jwt);

		CartItem updatedCartItem = null;
		if (cartItem.getQuantity() > 0) {
			updatedCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
		}

		return new ResponseEntity<>(updatedCartItem, HttpStatus.ACCEPTED);
	}

}

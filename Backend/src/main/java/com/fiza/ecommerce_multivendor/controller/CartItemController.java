package com.fiza.ecommerce_multivendor.controller;

import com.fiza.ecommerce_multivendor.exception.CartItemException;
import com.fiza.ecommerce_multivendor.exception.UserException;

import com.fiza.ecommerce_multivendor.model.CartItem;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.response.ApiResponse;
import com.fiza.ecommerce_multivendor.service.CartItemService;
import com.fiza.ecommerce_multivendor.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {

	private CartItemService cartItemService;
	private UserService userService;

	public CartItemController(CartItemService cartItemService, UserService userService) {
		this.cartItemService = cartItemService;
		this.userService = userService;
	}

}

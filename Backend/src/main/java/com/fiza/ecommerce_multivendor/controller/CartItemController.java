package com.fiza.ecommerce_multivendor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.service.CartItemService;
import com.fiza.ecommerce_multivendor.service.UserService;

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

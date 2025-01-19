package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.exception.ProductException;
import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.CartItem;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.request.AddItemRequest;

public interface CartService {

	public CartItem addCartItem(User user,
			Product product,
			String size,
			int quantity) throws ProductException;

	public Cart findUserCart(User user);

}

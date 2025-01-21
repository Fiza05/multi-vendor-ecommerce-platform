package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.exception.CartItemException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.CartItem;

public interface CartItemService {

	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem)
			throws CartItemException, UserException;

	public void removeCartItem(Long userId, Long cartItemId)
			throws CartItemException, UserException;

	public CartItem findCartItemById(Long cartItemId) throws CartItemException;

}

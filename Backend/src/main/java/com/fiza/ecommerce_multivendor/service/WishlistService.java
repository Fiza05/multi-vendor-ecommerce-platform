package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.exception.WishlistNotFoundException;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.model.Wishlist;

import java.util.Optional;

public interface WishlistService {

    Wishlist createWishlist(User user);

    Wishlist getWishlistByUserId(User user);

    Wishlist addProductToWishlist(User user, Product product) throws WishlistNotFoundException;

}

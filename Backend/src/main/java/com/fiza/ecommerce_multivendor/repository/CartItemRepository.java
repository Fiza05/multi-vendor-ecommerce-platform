package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);

}

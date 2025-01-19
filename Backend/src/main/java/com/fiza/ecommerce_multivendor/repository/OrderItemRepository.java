package com.fiza.ecommerce_multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

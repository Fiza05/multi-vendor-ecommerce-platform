package com.fiza.ecommerce_multivendor.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fiza.ecommerce_multivendor.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

    List<Order> findBySellerIdOrderByOrderDateDesc(Long sellerId);

    List<Order> findBySellerIdAndOrderDateBetween(Long sellerId, LocalDateTime startDate, LocalDateTime endDate);

}

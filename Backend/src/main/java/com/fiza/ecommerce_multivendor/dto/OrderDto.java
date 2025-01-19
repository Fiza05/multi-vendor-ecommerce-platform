package com.fiza.ecommerce_multivendor.dto;

import com.fiza.ecommerce_multivendor.domain.OrderStatus;
import com.fiza.ecommerce_multivendor.domain.PaymentStatus;
import com.fiza.ecommerce_multivendor.model.Address;
import com.fiza.ecommerce_multivendor.model.OrderItem;
import com.fiza.ecommerce_multivendor.model.PaymentDetails;
import com.fiza.ecommerce_multivendor.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    private String orderId;

    private UserDto user;

    private Long sellerId;

    private List<OrderItemDto> orderItems = new ArrayList<>();

    private Address shippingAddress;

    private PaymentDetails paymentDetails = new PaymentDetails();

    private double totalMrpPrice;

    private Integer totalSellingPrice;

    private Integer discount;

    private OrderStatus orderStatus;

    private int totalItem;

    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private LocalDateTime orderDate = LocalDateTime.now();
    private LocalDateTime deliverDate = orderDate.plusDays(7);

}

package com.fiza.ecommerce_multivendor.dto;

import com.fiza.ecommerce_multivendor.model.User;
import lombok.Data;

import java.util.List;

@Data
public class OrderHistory {
    private Long id;
    private UserDto user;
    private List<OrderDto> currentOrders;
    private int totalOrders;
    private int cancelledOrders;
    private int completedOrders;
    private int pendingOrders;
}

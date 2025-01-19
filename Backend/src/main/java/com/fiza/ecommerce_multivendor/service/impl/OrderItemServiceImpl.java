package com.fiza.ecommerce_multivendor.service.impl;

import com.fiza.ecommerce_multivendor.exception.OrderException;
import com.fiza.ecommerce_multivendor.model.OrderItem;
import com.fiza.ecommerce_multivendor.repository.OrderItemRepository;
import com.fiza.ecommerce_multivendor.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem getOrderItemById(Long id) throws Exception {

        System.out.println("------- " + id);
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        if (orderItem.isPresent()) {
            return orderItem.get();
        }
        throw new OrderException("Order item not found");
    }
}

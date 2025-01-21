package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.OrderItem;

public interface OrderItemService {

	OrderItem getOrderItemById(Long id) throws Exception;

}

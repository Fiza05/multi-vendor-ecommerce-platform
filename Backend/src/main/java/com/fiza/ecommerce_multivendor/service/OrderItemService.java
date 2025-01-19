package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.exception.OrderException;
import com.fiza.ecommerce_multivendor.model.OrderItem;
import com.fiza.ecommerce_multivendor.model.Product;

public interface OrderItemService {

	OrderItem getOrderItemById(Long id) throws Exception;

}

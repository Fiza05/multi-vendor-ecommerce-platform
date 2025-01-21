package com.fiza.ecommerce_multivendor.service;

import java.util.List;
import java.util.Set;

import com.fiza.ecommerce_multivendor.domain.OrderStatus;
import com.fiza.ecommerce_multivendor.exception.OrderException;
import com.fiza.ecommerce_multivendor.model.Address;
import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.User;

public interface OrderService {

	public Set<Order> createOrder(User user, Address shippingAddress, Cart cart);

	public Order findOrderById(Long orderId) throws OrderException;

	public List<Order> usersOrderHistory(Long userId);

	public List<Order> getShopsOrders(Long sellerId);

	public Order updateOrderStatus(Long orderId, OrderStatus orderStatus) throws OrderException;

	public void deleteOrder(Long orderId) throws OrderException;

	Order cancelOrder(Long orderId, User user) throws OrderException;

}

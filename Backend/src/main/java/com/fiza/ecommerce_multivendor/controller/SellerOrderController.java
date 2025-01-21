package com.fiza.ecommerce_multivendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.domain.OrderStatus;
import com.fiza.ecommerce_multivendor.exception.OrderException;
import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.response.ApiResponse;
import com.fiza.ecommerce_multivendor.service.OrderService;
import com.fiza.ecommerce_multivendor.service.SellerService;

@RestController
@RequestMapping("/seller/orders")
public class SellerOrderController {

	private final OrderService orderService;

	private final SellerService sellerService;

	@Autowired
	public SellerOrderController(OrderService orderService,

			SellerService sellerService) {
		this.orderService = orderService;
		this.sellerService = sellerService;
	}

	@GetMapping()
	public ResponseEntity<List<Order>> getAllOrdersHandler(
			@RequestHeader("Authorization") String jwt) throws SellerException {
		Seller seller = sellerService.getSellerProfile(jwt);
		List<Order> orders = orderService.getShopsOrders(seller.getId());

		return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/{orderId}/status/{orderStatus}")
	public ResponseEntity<Order> updateOrderHandler(@RequestHeader("Authorization") String jwt,
			@PathVariable Long orderId, @PathVariable OrderStatus orderStatus)
			throws OrderException {

		Order orders = orderService.updateOrderStatus(orderId, orderStatus);

		return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{orderId}/delete")
	public ResponseEntity<ApiResponse> deleteOrderHandler(@PathVariable Long orderId,
			@RequestHeader("Authorization") String jwt) throws OrderException {
		orderService.deleteOrder(orderId);
		ApiResponse res = new ApiResponse("Order Deleted Successfully", true);
		System.out.println("delete method working....");
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}

}

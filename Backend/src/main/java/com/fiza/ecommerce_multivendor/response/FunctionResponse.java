package com.fiza.ecommerce_multivendor.response;

import com.fiza.ecommerce_multivendor.dto.OrderHistory;
import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}

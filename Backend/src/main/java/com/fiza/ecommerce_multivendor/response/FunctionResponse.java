package com.fiza.ecommerce_multivendor.response;

import com.fiza.ecommerce_multivendor.dto.OrderHistory;
import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.Order;
import com.fiza.ecommerce_multivendor.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}

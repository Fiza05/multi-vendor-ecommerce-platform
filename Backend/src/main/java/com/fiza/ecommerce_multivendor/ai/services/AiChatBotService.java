package com.fiza.ecommerce_multivendor.ai.services;

import com.fiza.ecommerce_multivendor.exception.ProductException;
import com.fiza.ecommerce_multivendor.response.ApiResponse;

public interface AiChatBotService {

    ApiResponse aiChatBot(String prompt, Long productId, Long userId) throws ProductException;
}

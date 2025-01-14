package com.fiza.ecommerce_multivendor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.response.ApiResponse;

@RestController
public class HomeController {

    @GetMapping
    public ApiResponse home() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Welcome to E-commerce Multivendor API");
        return apiResponse;
    }
}

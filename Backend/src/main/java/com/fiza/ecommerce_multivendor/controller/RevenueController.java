package com.fiza.ecommerce_multivendor.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.dto.RevenueChart;
import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.service.RevenueService;
import com.fiza.ecommerce_multivendor.service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seller/revenue/chart")
public class RevenueController {
    private final RevenueService revenueService;
    private final SellerService sellerService;

    @GetMapping()
    public ResponseEntity<List<RevenueChart>> getRevenueChart(
            @RequestParam(defaultValue = "today") String type,
            @RequestHeader("Authorization") String jwt) throws SellerException {
        Seller seller = sellerService.getSellerProfile(jwt);
        List<RevenueChart> revenue = revenueService.getRevenueChartByType(type, seller.getId());
        return ResponseEntity.ok(revenue);
    }

}

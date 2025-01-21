package com.fiza.ecommerce_multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.SellerReport;

public interface SellerReportRepository extends JpaRepository<SellerReport, Long> {
    SellerReport findBySellerId(Long sellerId);
}

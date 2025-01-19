package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.SellerReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerReportRepository extends JpaRepository<SellerReport, Long> {
    SellerReport findBySellerId(Long sellerId);
}

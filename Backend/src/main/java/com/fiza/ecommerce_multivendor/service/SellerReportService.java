package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.SellerReport;

public interface SellerReportService {
    SellerReport getSellerReport(Seller seller);

    SellerReport updateSellerReport(SellerReport sellerReport);

}

package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.SellerReport;
import java.util.List;
import java.util.Optional;

public interface SellerReportService {
    SellerReport getSellerReport(Seller seller);

    SellerReport updateSellerReport(SellerReport sellerReport);

}

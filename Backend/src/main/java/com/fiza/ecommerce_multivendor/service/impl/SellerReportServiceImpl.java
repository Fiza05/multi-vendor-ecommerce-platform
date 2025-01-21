package com.fiza.ecommerce_multivendor.service.impl;

import org.springframework.stereotype.Service;

import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.model.SellerReport;
import com.fiza.ecommerce_multivendor.repository.SellerReportRepository;
import com.fiza.ecommerce_multivendor.service.SellerReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerReportServiceImpl implements SellerReportService {

    private final SellerReportRepository sellerReportRepository;

    @Override
    public SellerReport getSellerReport(Seller seller) {
        SellerReport report = sellerReportRepository.findBySellerId(seller.getId());
        if (report == null) {
            SellerReport newReport = new SellerReport();
            newReport.setSeller(seller);
            return sellerReportRepository.save(newReport);
        }
        return report;
    }

    @Override
    public SellerReport updateSellerReport(SellerReport sellerReport) {

        return sellerReportRepository.save(sellerReport);
    }

}

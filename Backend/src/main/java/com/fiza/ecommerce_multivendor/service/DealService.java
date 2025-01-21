package com.fiza.ecommerce_multivendor.service;

import java.util.List;

import com.fiza.ecommerce_multivendor.model.Deal;

public interface DealService {
    Deal createDeal(Deal deal);

    // List<Deal> createDeals(List<Deal> deals);
    List<Deal> getDeals();

    Deal updateDeal(Deal deal, Long id) throws Exception;

    void deleteDeal(Long id) throws Exception;

}

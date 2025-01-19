package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.domain.AccountStatus;
import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.model.Seller;
import java.util.List;
import java.util.Optional;

public interface SellerService {
    Seller getSellerProfile(String jwt) throws SellerException;

    Seller createSeller(Seller seller) throws SellerException;

    Seller getSellerById(Long id) throws SellerException;

    Seller getSellerByEmail(String email) throws SellerException;

    List<Seller> getAllSellers(AccountStatus status);

    Seller updateSeller(Long id, Seller seller) throws SellerException;

    void deleteSeller(Long id) throws SellerException;

    Seller verifyEmail(String email, String otp) throws SellerException;

    Seller updateSellerAccountStatus(Long sellerId, AccountStatus status) throws SellerException;
}

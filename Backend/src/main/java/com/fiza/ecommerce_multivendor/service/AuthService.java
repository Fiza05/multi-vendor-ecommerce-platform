package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.request.LoginRequest;
import com.fiza.ecommerce_multivendor.request.SignupRequest;
import com.fiza.ecommerce_multivendor.response.AuthResponse;

import jakarta.mail.MessagingException;

public interface AuthService {

    void sentLoginOtp(String email) throws UserException, MessagingException;

    String createUser(SignupRequest req) throws SellerException;

    AuthResponse signin(LoginRequest req) throws SellerException;

}

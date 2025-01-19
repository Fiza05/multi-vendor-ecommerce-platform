package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.VerificationCode;

public interface VerificationService {

    VerificationCode createVerificationCode(String otp, String email);
}

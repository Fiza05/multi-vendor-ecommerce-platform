package com.fiza.ecommerce_multivendor.request;

import lombok.Data;

@Data
public class ResetPasswordRequest {

	private String password;
	private String token;

}

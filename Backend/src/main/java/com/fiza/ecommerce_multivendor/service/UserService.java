package com.fiza.ecommerce_multivendor.service;

import java.util.List;

import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;

	public User findUserByEmail(String email) throws UserException;

}

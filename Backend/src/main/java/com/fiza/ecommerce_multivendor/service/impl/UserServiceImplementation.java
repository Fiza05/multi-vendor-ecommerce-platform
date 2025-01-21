package com.fiza.ecommerce_multivendor.service.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fiza.ecommerce_multivendor.config.JwtProvider;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.repository.PasswordResetTokenRepository;
import com.fiza.ecommerce_multivendor.repository.UserRepository;
import com.fiza.ecommerce_multivendor.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private PasswordResetTokenRepository passwordResetTokenRepository;
	private JavaMailSender javaMailSender;

	public UserServiceImplementation(UserRepository userRepository, JwtProvider jwtProvider,
			PasswordEncoder passwordEncoder,
			PasswordResetTokenRepository passwordResetTokenRepository,
			JavaMailSender javaMailSender) {

		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
		this.passwordEncoder = passwordEncoder;
		this.passwordResetTokenRepository = passwordResetTokenRepository;
		this.javaMailSender = javaMailSender;

	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailFromJwtToken(jwt);

		User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UserException("user not exist with email " + email);
		}
		return user;
	}

	@Override
	public User findUserByEmail(String username) throws UserException {

		User user = userRepository.findByEmail(username);

		if (user != null) {

			return user;
		}

		throw new UserException("user not exist with username " + username);
	}

}

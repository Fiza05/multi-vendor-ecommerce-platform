package com.fiza.ecommerce_multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String username);

}

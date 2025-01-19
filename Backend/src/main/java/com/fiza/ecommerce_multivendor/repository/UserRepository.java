package com.fiza.ecommerce_multivendor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiza.ecommerce_multivendor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String username);

}

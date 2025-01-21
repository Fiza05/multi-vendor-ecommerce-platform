package com.fiza.ecommerce_multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.HomeCategory;

public interface HomeCategoryRepository extends JpaRepository<HomeCategory, Long> {
}

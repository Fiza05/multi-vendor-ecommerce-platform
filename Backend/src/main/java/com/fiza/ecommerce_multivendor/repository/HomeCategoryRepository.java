package com.fiza.ecommerce_multivendor.repository;

import com.fiza.ecommerce_multivendor.model.HomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeCategoryRepository extends JpaRepository<HomeCategory, Long> {
}

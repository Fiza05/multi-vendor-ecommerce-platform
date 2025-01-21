package com.fiza.ecommerce_multivendor.service;

import java.util.List;

import com.fiza.ecommerce_multivendor.model.HomeCategory;

public interface HomeCategoryService {
    HomeCategory createCategory(HomeCategory categories);

    List<HomeCategory> createCategories(List<HomeCategory> categories);

    List<HomeCategory> getAllCategories();

    HomeCategory updateCategory(HomeCategory categories, Long id) throws Exception;
}

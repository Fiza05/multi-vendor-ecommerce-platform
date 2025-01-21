package com.fiza.ecommerce_multivendor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiza.ecommerce_multivendor.model.HomeCategory;
import com.fiza.ecommerce_multivendor.repository.HomeCategoryRepository;
import com.fiza.ecommerce_multivendor.service.HomeCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeCategoryServiceImpl implements HomeCategoryService {

    private final HomeCategoryRepository homeCategoryRepository;

    @Override
    public HomeCategory createCategory(HomeCategory categories) {

        return homeCategoryRepository.save(categories);

    }

    @Override
    public List<HomeCategory> createCategories(List<HomeCategory> categories) {
        if (homeCategoryRepository.findAll().isEmpty()) {
            return homeCategoryRepository.saveAll(categories);
        }
        return homeCategoryRepository.findAll();
    }

    @Override
    public List<HomeCategory> getAllCategories() {
        return homeCategoryRepository.findAll();
    }

    @Override
    public HomeCategory updateCategory(HomeCategory category, Long id) throws Exception {
        HomeCategory existingCategory = homeCategoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category not found"));
        if (category.getImage() != null) {
            existingCategory.setImage(category.getImage());
        }
        if (category.getCategoryId() != null) {
            existingCategory.setCategoryId(category.getCategoryId());
        }
        return homeCategoryRepository.save(existingCategory);
    }

}

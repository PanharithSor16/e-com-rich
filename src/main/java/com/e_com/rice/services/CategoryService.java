package com.e_com.rice.services;

import com.e_com.rice.models.Category;

import java.util.List;


public interface   CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
}

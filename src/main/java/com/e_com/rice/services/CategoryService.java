package com.e_com.rice.services;

import com.e_com.rice.models.Category;
import com.e_com.rice.payload.CategoryDTO;
import com.e_com.rice.payload.CategoryResponse;

import java.util.List;


public interface   CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
   // void createCategory(Category category);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}

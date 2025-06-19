package com.e_com.rice.services;

import com.e_com.rice.exception.APIException;
import com.e_com.rice.exception.ResourceNotFoundException;
import com.e_com.rice.models.Category;
import com.e_com.rice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty())
            throw new APIException("No category create till now. ");
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category saveCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (saveCategory != null)
            throw new APIException(" Category with the name " + category.getCategoryName() + " already exists !!!");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category deletedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category", categoryId));
        categoryRepository.delete(deletedCategory);
        return "Category with categoryId: " + categoryId + " deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savaCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category", categoryId));

        category.setCategoryId(categoryId);
       // category.setCategoryName(category.getCategoryName());
        savaCategory = categoryRepository.save(category);

        return  savaCategory;
    }
}

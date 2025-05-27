package com.e_com.rice.controller;

import com.e_com.rice.models.Category;
import com.e_com.rice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping ("/get-category")
    public List<Category> getCategory(){

        List<Category> CategoryList = categoryService.getCategories();
        return CategoryList;
    }
    @PostMapping("/create-category")
    public String createCategory(@RequestBody Category category){
        Category create = new Category();
        create.setCategory(category.getCategory());
        create.setId(category.getId());
        return "Success";
    }
    @PutMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> categories = categoryService.getCategories().stream().filter(e -> Objects.equals(e.getId(), id)).findFirst();
        if (categories.isPresent()){

        }
    }
}

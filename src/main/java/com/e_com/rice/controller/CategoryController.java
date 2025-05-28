package com.e_com.rice.controller;

import com.e_com.rice.models.Category;
import com.e_com.rice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private Category category;

    @GetMapping ("/get-category")
    public ResponseEntity<List<Category>> getCategory(){

        List<Category> CategoryList = categoryService.getCategories();
        return ResponseEntity.ok(CategoryList);
    }
    @PostMapping("/create-category")
    public ResponseEntity<String> createCategory(@RequestBody Category category){

        category.setCategory(category.getCategory());
        category.setId(category.getId());
        return ResponseEntity.ok( "Success");
    }
    @GetMapping("category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id)  {
        Optional<Category> categories = categoryService.getCategories().stream()
                .filter(e ->Objects.equals(e.getId(), id)).findFirst();
        if (categories.isPresent()){
            return ResponseEntity.ok(categories.get());
        }
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with ID "+ id + " Not Found");
    }
    @PutMapping("/update-category/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category1){
        Optional<Category> categories = categoryService.getCategories().stream().filter(e -> Objects.equals(e.getId(), id)).findFirst();
        if (categories.isPresent()){
            Category exisingCategory = categories.get();

        }
        return ResponseEntity.ok( "Update Success");
    }
}

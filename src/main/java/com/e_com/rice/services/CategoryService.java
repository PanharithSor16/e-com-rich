package com.e_com.rice.services;

import com.e_com.rice.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private List<Category> categories = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }
}

package com.example.listingapp.service;

import com.example.listingapp.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAllCategories();

    Optional<Category> findById(int id);

    Category addCategory(Category category);

    ResponseEntity<Category> updateCategory(int id, Category category);

    ResponseEntity<Category> deleteCategory(int id);
}

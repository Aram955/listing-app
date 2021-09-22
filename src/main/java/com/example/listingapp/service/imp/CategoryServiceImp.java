package com.example.listingapp.service.imp;

import com.example.listingapp.model.Category;
import com.example.listingapp.repository.CategoryRepository;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll() ;
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<Category> updateCategory(int id, Category category) {
        Optional<Category> categoryByUpdate = categoryRepository.findById(id);
        if (categoryByUpdate.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Category categoryDB = categoryByUpdate.get();
        categoryDB.setName(category.getName());
        return ResponseEntity.ok().body(categoryRepository.save(categoryDB));
    }

    @Override
    public ResponseEntity<Category> deleteCategory(int id) {
        Optional<Category> categoryById = categoryRepository.findById(id);
        if (categoryById.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

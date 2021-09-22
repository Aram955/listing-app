package com.example.listingapp.endpoint;

import com.example.listingapp.model.Category;

import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {


    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> categories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getcategory(@PathVariable("id") int id){
            return categoryService.findById(id).orElse(null);
    }
    @PostMapping("/categories")
    private Category category(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/categories/{id}")
    private ResponseEntity<Category> updateById(@PathVariable("id") int id, @RequestBody Category category){
     return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/categories/{id}")
    private ResponseEntity<Category> deleteById(@PathVariable ("id") int id){
       return categoryService.deleteCategory(id);
    }


}

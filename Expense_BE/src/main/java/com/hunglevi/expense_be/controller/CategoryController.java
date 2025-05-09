package com.hunglevi.expense_be.controller;

import com.hunglevi.expense_be.model.Category;
import com.hunglevi.expense_be.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        return (category != null) ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public List<Category> getAllCategoriesByUserId(@PathVariable Integer userId) {
        return categoryService.getAllCategoriesByUserId(userId);
    }

    @GetMapping("/search")
    public List<Category> searchCategoriesByName(@RequestParam String searchTerm) {
        return categoryService.searchCategoriesByName(searchTerm);
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
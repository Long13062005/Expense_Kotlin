package com.hunglevi.expense_be.services.impl;

import com.hunglevi.expense_be.model.Category;
import com.hunglevi.expense_be.repository.CategoryRepository;
import com.hunglevi.expense_be.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public List<Category> getAllCategoriesByUserId(Integer userId) {
        return categoryRepository.getAllCategoriesByUserId(userId);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> searchCategoriesByName(String searchTerm) {
        return categoryRepository.searchCategoriesByName(searchTerm);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
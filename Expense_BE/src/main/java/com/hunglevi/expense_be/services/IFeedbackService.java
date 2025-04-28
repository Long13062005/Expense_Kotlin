package com.hunglevi.expense_be.services;

import com.hunglevi.expense_be.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    List<Category> getAllCategoriesByUserId(Integer userId);
    Category getCategoryById(Integer id);
    List<Category> searchCategoriesByName(String searchTerm);
    Category saveCategory(Category category);
    void deleteCategory(Integer id);
}
package com.hunglevi.expense_be.services.impl;

import com.hunglevi.expense_be.model.Budget;
import com.hunglevi.expense_be.model.Category;
import com.hunglevi.expense_be.repository.BudgetRepository;
import com.hunglevi.expense_be.repository.CategoryRepository;
import com.hunglevi.expense_be.services.IBudgetService;
import com.hunglevi.expense_be.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements IBudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<Budget> getAllBudgets() {
        return List.of();
    }

    @Override
    public Budget getBudgetById(Integer id) {
        return null;
    }

    @Override
    public Budget saveBudget(Budget budget) {
        return null;
    }

    @Override
    public void deleteBudget(Integer id) {

    }

    @Override
    public List<Budget> getBudgetsByUserId(Integer userId) {
        return List.of();
    }

    @Override
    public Budget getBudgetByCategoryAndUserId(String category, Integer userId) {
        return null;
    }
}
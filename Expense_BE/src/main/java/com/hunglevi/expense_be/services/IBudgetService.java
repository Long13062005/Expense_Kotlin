package com.hunglevi.expense_be.services;

import com.hunglevi.expense_be.model.Budget;
import com.hunglevi.expense_be.model.Category;

import java.util.List;

public interface IBudgetService {
    List<Budget> getAllBudgets();
    Budget getBudgetById(Integer id);
    Budget saveBudget(Budget budget);
    void deleteBudget(Integer id);
    List<Budget> getBudgetsByUserId(Integer userId);
    Budget getBudgetByCategoryAndUserId(String category, Integer userId);
}
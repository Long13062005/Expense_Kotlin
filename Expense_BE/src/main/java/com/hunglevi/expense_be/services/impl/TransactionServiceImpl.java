package com.hunglevi.expense_be.services.impl;

import com.hunglevi.expense_be.model.Category;
import com.hunglevi.expense_be.repository.CategoryRepository;
import com.hunglevi.expense_be.repository.TransactionRepository;
import com.hunglevi.expense_be.services.ICategoryService;
import com.hunglevi.expense_be.services.ITransactionService;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Integer userId) {
        return List.of();
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return null;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public void deleteTransaction(Integer id) {

    }

    @Override
    public List<Transaction> getTransactionsByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionsBetweenDates(String startDate, String endDate) {
        return List.of();
    }
}
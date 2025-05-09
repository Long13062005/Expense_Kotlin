package com.hunglevi.expense_be.services;

import com.hunglevi.expense_be.model.Category;
import jakarta.transaction.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByUserId(Integer userId);
    Transaction getTransactionById(Integer id);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Integer id);
    List<Transaction> getTransactionsByCategory(String category);
    List<Transaction> getTransactionsBetweenDates(String startDate, String endDate);
}

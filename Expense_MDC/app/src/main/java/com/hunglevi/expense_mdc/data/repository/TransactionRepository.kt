package com.hunglevi.expense_mdc.data.repository

import com.hunglevi.expense_mdc.data.dao.TransactionDao
import com.hunglevi.expense_mdc.data.model.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val transactionDao: TransactionDao) {

    val allTransactions: Flow<List<Transaction>> = transactionDao.getAllTransactions()

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }

    suspend fun getTransactionById(id: Int): Transaction? {
        return transactionDao.getTransactionById(id)
    }
    fun getAllTransactionsByUserId(userId: Int): Flow<List<Transaction>> {
        return transactionDao.getAllTransactionsByUserId(userId)
    }
}
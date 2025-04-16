package com.hunglevi.expense_mdc.data.repository

import com.hunglevi.expense_mdc.data.dao.CategoryDao
import com.hunglevi.expense_mdc.data.model.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao) {
    val allCategories: Flow<List<Category>> = categoryDao.getAllCategories()

    fun getCategoriesByUserId(userId: Int): Flow<List<Category>> {
        return categoryDao.getAllCategoriesByUserId(userId)
    }
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    suspend fun getCategoryById(id: Int): Category? {
        return categoryDao.getCategoryById(id)
    }
}
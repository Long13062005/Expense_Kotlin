package com.hunglevi.expense_mdc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets")
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,           // Auto-increment primary key
    val userId: Int,          // User ID
    val categoryId: Int,      // Transaction category
    val amount: Double,        // Transaction amount
    val period : String,         // Budget period (e.g., monthly, yearly)
    val createdAt: String
)
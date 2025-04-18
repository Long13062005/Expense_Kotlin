package com.hunglevi.expense_mdc.data.repository

import com.hunglevi.expense_mdc.data.dao.UserDao
import com.hunglevi.expense_mdc.data.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    val allUsers: Flow<List<User>> = userDao.getAllUsers()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun getUserById(id: Int): User? {
        return userDao.getUserById(id)
    }
    suspend fun authenticateUser(email: String, password: String): User? {
        return userDao.authenticateUser(email, password)
    }
}
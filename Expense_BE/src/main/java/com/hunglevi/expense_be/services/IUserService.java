package com.hunglevi.expense_be.services;

import com.hunglevi.expense_be.model.User;

import java.util.List;
public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveOrUpdateUser(User user);
    void deleteUser(Long id);
    User authenticateUser(String email, String password);
    List<User> searchUsersByName(String searchTerm);
}
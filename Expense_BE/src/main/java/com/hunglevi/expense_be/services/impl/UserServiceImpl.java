package com.hunglevi.expense_be.services.impl;

import com.hunglevi.expense_be.model.User;
import com.hunglevi.expense_be.repository.UserRepository;
import com.hunglevi.expense_be.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllOrderByCreatedAt();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User authenticateUser(String email, String password) {
        return userRepository.authenticateUser(email, password);
    }

    @Override
    public List<User> searchUsersByName(String searchTerm) {
        return userRepository.searchUsersByName(searchTerm);
    }
}
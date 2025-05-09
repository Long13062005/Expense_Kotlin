package com.hunglevi.expense_be.repository;

import com.hunglevi.expense_be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u ORDER BY u.createdAt DESC")
    List<User> findAllOrderByCreatedAt();

    @Query("SELECT u FROM users u WHERE u.id = :id")
    User findUserById(@Param("id") Integer id);

    @Query("SELECT u FROM users u WHERE u.email = :email AND u.password = :password")
    User authenticateUser(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM users u WHERE u.username LIKE %:searchTerm%")
    List<User> searchUsersByName(@Param("searchTerm") String searchTerm);
}

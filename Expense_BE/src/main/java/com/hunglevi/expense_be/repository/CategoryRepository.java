package com.hunglevi.expense_be.repository;

import com.hunglevi.expense_be.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM categories c ORDER BY c.name ASC")
    List<Category> getAllCategories();

    @Query("SELECT c FROM categories c WHERE c.user.id = :userId ORDER BY c.name ASC")
    List<Category> getAllCategoriesByUserId(@Param("userId") Integer userId);

    @Query("SELECT c FROM categories c WHERE c.id = :id")
    Category getCategoryById(@Param("id") Integer id);

    @Query("SELECT c FROM categories c WHERE c.name LIKE %:searchTerm%")
    List<Category> searchCategoriesByName(@Param("searchTerm") String searchTerm);
}
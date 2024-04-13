package com.example.springboot.repository;

import com.example.springboot.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FoodRepo extends JpaRepository<Food, Integer> {

    @Query("SELECT f FROM Food f WHERE f.foodName = ?1")
    List<Food> findByFoodName(String foodName); // Changed query to select from Food instead of Bus
    
    @Query("SELECT f FROM Food f WHERE f.id IN (SELECT DISTINCT f.id FROM Food f INNER JOIN f.users u WHERE u.id = ?1)")
    List<Food> findByUserId(int userId); // Changed query to select from Food instead of Bus
}



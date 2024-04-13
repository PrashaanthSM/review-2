package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Food;
import com.example.springboot.repository.FoodRepo;

@Service
public class FoodService {

    @Autowired
    FoodRepo foodRepository;

    public Food create(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodById(int id) {
        return foodRepository.findById(id);
    }

    public boolean updateFood(int id, Food food) {
        if (!foodRepository.existsById(id)) {
            return false;
        }
        food.setId(id);
        foodRepository.save(food);
        return true;
    }

    public boolean deleteFood(int id) {
        if (!foodRepository.existsById(id)) {
            return false;
        }
        foodRepository.deleteById(id);
        return true;
    }

    public List<Food> getAllFoodsSortedBy(String sortBy) {
        return foodRepository.findAll(Sort.by(sortBy));
    }

    public Page<Food> getAllFoodsPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return foodRepository.findAll(pageable);
    }
    
    public List<Food> findByFoodName(String foodName) {
        return foodRepository.findByFoodName(foodName);
    }

    public List<Food> findByUserId(int userId) {
        return foodRepository.findByUserId(userId);
    }

}

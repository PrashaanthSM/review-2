package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Food;
import com.example.springboot.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/food") // Changed the request mapping to /api/food
public class FoodController {

    @Autowired
    private FoodService foodService; // Updated to use FoodService

    @PostMapping // Changed the method name and parameter names to reflect food entities
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food newFood = foodService.create(food);
        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }

    @GetMapping // Changed the method name and return type to reflect food entities
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/{id}") // Changed the method name and path variable to reflect food entities
    public ResponseEntity<Food> getFoodById(@PathVariable("id") int id) {
        Food food = foodService.getFoodById(id).orElse(null);
        if (food != null) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}") // Changed the method name and parameter names to reflect food entities
    public ResponseEntity<Food> updateFood(@PathVariable("id") int id, @RequestBody Food food) {
        if (foodService.updateFood(id, food)) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}") // Changed the method name and path variable to reflect food entities
    public ResponseEntity<Boolean> deleteFood(@PathVariable("id") int id) {
        if (foodService.deleteFood(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted") // Changed the method name to reflect food entities
    public ResponseEntity<List<Food>> getAllFoodsSorted(@RequestParam String sortBy) {
        List<Food> foods = foodService.getAllFoodsSortedBy(sortBy);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/page") // Changed the method name to reflect food entities
    public ResponseEntity<Page<Food>> getAllFoodsPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Food> foodsPage = foodService.getAllFoodsPaginated(pageNo, pageSize);
        return new ResponseEntity<>(foodsPage, HttpStatus.OK);
    }

    // Additional endpoints for food-related operations can be added here
}

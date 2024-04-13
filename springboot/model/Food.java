package com.example.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String foodName; // Changed from busName to foodName

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<User> users; // Updated the mappedBy attribute to reflect the relationship with users

    // Constructors, getters, and setters
    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

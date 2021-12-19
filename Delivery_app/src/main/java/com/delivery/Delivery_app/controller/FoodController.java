package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.entity.Food;
import com.delivery.Delivery_app.entity.Restaurant;
import com.delivery.Delivery_app.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;
    //    get all food endpoint
    @GetMapping("/foods")
    public List<Food> getAllFoods(){
        return foodService.getAllFoods();
    }

    //    get food endpoint
    @GetMapping("/food/{id}")
    public Food getRestaurant(@PathVariable("id") long food_id){
        return foodService.getFood(food_id);
    }

    //    add food endpoint
    @PostMapping("/food/restaurant/{id}")
    public Food addFood(@RequestBody Food food,@PathVariable("id") long restaurant_id){
        return foodService.addFood(food,restaurant_id);
    }
    //    update existing food
    @PutMapping("/food")
    public String updateFood(@RequestBody Food food){
        return foodService.updateFood(food);
    }

    //  Delete food from existing db

    @DeleteMapping("/food/{id}")
    public String deleteRestaurant(@PathVariable("id") long food_id ){
        boolean flag = foodService.deleteFood(food_id);
        if(flag) return "Delete Food";
        else return "Delete Failed";
    }

}

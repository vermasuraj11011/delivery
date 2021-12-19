package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.entity.Restaurant;
import com.delivery.Delivery_app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

//    get all restaurant endpoint
    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

//    get restaurant endpoint
    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable("id") long restaurant_id){
        return restaurantService.getRestaurant(restaurant_id);
    }

//    add restaurant endpoint
    @PostMapping("/restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }

//    update existing restaurant
    @PutMapping("/restaurant")
    public String updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

//  Delete restaurant from existing db
    @DeleteMapping("/restaurant/{id}")
    public String deleteRestaurant(@PathVariable("id") long restaurant_id ){
        boolean flag = restaurantService.deleteRestaurant(restaurant_id);
        if(flag) return "Delete Restaurant";
        else return "Delete Failed";
    }

}

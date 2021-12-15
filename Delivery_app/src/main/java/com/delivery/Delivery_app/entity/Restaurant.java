package com.delivery.Delivery_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    private Long restaurant_id;
    private String restaurant_name;
    private String restaurant_address;

    @OneToMany(mappedBy = "restaurant")
    List<Food> foodList = new ArrayList<>();

    public void addFood(Food food){
        this.foodList.add(food);
    }

    public void removeFood(Food food){
        this.foodList.remove(food);
    }
    
}

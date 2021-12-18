package com.delivery.Delivery_app.service;

import com.delivery.Delivery_app.dto.CartDTO;
import com.delivery.Delivery_app.entity.Cart;
import com.delivery.Delivery_app.entity.Food;
import com.delivery.Delivery_app.exception.EmptyValueException;
import com.delivery.Delivery_app.repository.CartRepository;
import com.delivery.Delivery_app.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    FoodRepository foodRepository;

    //
    public void addFoodToCart(Long cartId, Long foodId, Long quantity) {

        if(cartId == null || foodId == null || quantity == null){
            throw new EmptyValueException("Input values are missing");
        }

        int count = cartRepository.checkIfFoodInCart(cartId,foodId);

        if(count == 0) {
            cartRepository.addFoodToCart(cartId,foodId,quantity);
        }
        else{
            cartRepository.updateQuantity(cartId,foodId,quantity);
        }
    }

    public void deleteFoodFromCart(Long cartId, Long foodId) {
        if(cartId == null || foodId == null){
            throw new EmptyValueException("Input values are missing");
        }
        cartRepository.deleteFoodFromCart(cartId,foodId);
    }

    public List getFoodListInCart(Long cartId) {
        if(cartId == null){
            throw new EmptyValueException("Cart ID is missing");
        }
        List<Cart> foodList = cartRepository.getListOfFood(cartId);

        List<CartDTO> cartDTOList = new ArrayList<>();

        for(int i=0; i<foodList.size(); i++){
            Food food =  foodRepository.findById(foodList.get(i).getFoodId()).get();

            cartDTOList.add(new CartDTO(food,foodList.get(i).getQuantity()));
        }

        return cartDTOList;
    }

    public void deleteCartData(Long cartId) {

        cartRepository.deleteCartData(cartId);
    }
}

package com.delivery.Delivery_app.service;

import com.delivery.Delivery_app.dto.CartDTO;
import com.delivery.Delivery_app.entity.Cart;
import com.delivery.Delivery_app.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    //
    public void addFoodToCart(Long cartId, Long foodId, Long quantity) {

        int count = cartRepository.checkIfFoodInCart(cartId,foodId);

        if(count == 0) {
            cartRepository.addFoodToCart(cartId,foodId,quantity);
        }
        else{
            cartRepository.updateQuantity(cartId,foodId,quantity);
        }
    }

    public void deleteFoodFromCart(Long cartId, Long foodId) {
        cartRepository.deleteFoodFromCart(cartId,foodId);
    }

    public List getFoodListInCart(Long cartId) {
        List<Cart> foodList = cartRepository.getListOfFood(cartId);

        List<CartDTO> cartDTOList = modelMapper().map(foodList, new TypeToken<List<CartDTO>>() {}.getType());

        return cartDTOList;
    }

    private static ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}

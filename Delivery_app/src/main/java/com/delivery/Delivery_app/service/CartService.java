package com.delivery.Delivery_app.service;

import com.delivery.Delivery_app.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public void addFoodToCart(Long cartId, Long foodId, Long quantity) {
        cartRepository.addFoodToCart(cartId,foodId,quantity);
    }

    public void deleteFoodFromCart(Long cartId, Long foodId) {
        cartRepository.deleteFoodFromCart(cartId,foodId);
    }

    public void getFoodListInCart(Long cartId) {

    }
}

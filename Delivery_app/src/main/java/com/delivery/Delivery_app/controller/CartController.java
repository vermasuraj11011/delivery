package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/cart/{cartId}/{foodId}/{quantity}")
    public ResponseEntity addFoodToCart(@PathVariable Long cartId,
                                        @PathVariable Long foodId,
                                        @PathVariable Long quantity){

        cartService.addFoodToCart(cartId,foodId,quantity);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cartId}/{foodId}")
    public ResponseEntity deleteFoodFromCart(@PathVariable Long cartId,
                                             @PathVariable Long foodId){

        cartService.deleteFoodFromCart(cartId,foodId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity getFoodListInCart(@PathVariable Long cartId){

        List foodList = cartService.getFoodListInCart(cartId);

        return new ResponseEntity(foodList,HttpStatus.OK);
    }
}

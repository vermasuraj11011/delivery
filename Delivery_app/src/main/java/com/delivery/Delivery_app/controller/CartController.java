package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addFood/{cartId}/{foodId}/{quantity}")
    public ResponseEntity addFoodToCart(@PathVariable("cartId") Long cartId,
                                        @PathVariable("foodId") Long foodId,
                                        @PathVariable("quantity") Long quantity){

        cartService.addFoodToCart(cartId,foodId,quantity);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteFood/{cartId}/{foodId}")
    public ResponseEntity deleteFoodFromCart(@PathVariable("cartId") Long cartId,
                                             @PathVariable("foodId") Long foodId){

        cartService.deleteFoodFromCart(cartId,foodId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCart/{cartId}")
    public ResponseEntity deleteCartData(@PathVariable("cartId") Long cartId){

        cartService.deleteCartData(cartId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/foodList/{cartId}")
    public ResponseEntity getFoodListInCart(@PathVariable("cartId") Long cartId){

        List foodList = cartService.getFoodListInCart(cartId);

        return new ResponseEntity(foodList,HttpStatus.OK);
    }
}

package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/{userId}/{cartId}")
    public ResponseEntity makeOrder(@PathVariable("userId") Long userId,
                                    @PathVariable("cartId") Long cartId){

        Long orderId = orderService.makeOrder(userId,cartId);

        return new ResponseEntity(orderId, HttpStatus.OK);
    }
}

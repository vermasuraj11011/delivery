package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.entity.Order;
import com.delivery.Delivery_app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/initialized/{userId}/{cartId}")
    public ResponseEntity makeOrder(@PathVariable("userId") Long userId,
                                    @PathVariable("cartId") Long cartId){

        Long orderId = orderService.makeOrder(userId,cartId);

        return new ResponseEntity(orderId, HttpStatus.OK);
    }

    @PostMapping("/cancel/{orderId}")
    public ResponseEntity cancelOrder(@PathVariable("orderId") Long orderId){

        orderService.cancelOrder(orderId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/success/{orderId}")
    public ResponseEntity successOrder(@PathVariable("orderId") Long orderId){

        orderService.successOrder(orderId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping ("/current/{userId}")
    public ResponseEntity getOrderDetails(@PathVariable("userId") Long userId){

        List<Order> orderList = orderService.getOrderDetails(userId);

        return new ResponseEntity(orderList,HttpStatus.OK);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity orderHistory(@PathVariable("userId") Long userId){

        List<Order> orderList = orderService.orderHistory(userId);

        return new ResponseEntity(orderList,HttpStatus.OK);
    }
}

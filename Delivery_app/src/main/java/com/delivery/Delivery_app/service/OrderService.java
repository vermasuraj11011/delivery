package com.delivery.Delivery_app.service;

import com.delivery.Delivery_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public int makeOrder(Long userId, Long cartId) {

        return 1;
    }
}

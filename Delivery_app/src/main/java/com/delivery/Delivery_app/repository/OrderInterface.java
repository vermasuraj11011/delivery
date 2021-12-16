package com.delivery.Delivery_app.repository;

import com.delivery.Delivery_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInterface extends JpaRepository<Order,Long> {

}

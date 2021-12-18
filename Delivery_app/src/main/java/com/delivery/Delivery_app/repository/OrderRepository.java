package com.delivery.Delivery_app.repository;

import com.delivery.Delivery_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//public interface OrderRepository extends Neo4jRepository<Order,Long> {
//
//    @Query("MATCH p=shortestPath((bacon:Place {name:$address_i})-[*]-(meg:Place {name:$address_f})RETURN length(p)")
//    Long findMinimumDistance(String address_i, String address_f);
//
//}

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "select o from Order o where o.userId = :userId and o.status = :stat")
    List<Order> getOrderDetails(Long userId,String stat);

    @Query(value = "select o from Order o where o.userId = :userId and o.status = :canceled or o.status = :successful")
    List<Order> orderHistory(Long userId, String canceled, String successful);
}
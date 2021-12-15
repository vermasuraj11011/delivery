package com.delivery.Delivery_app.repository;

import com.delivery.Delivery_app.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

    @Modifying
    @Query(value = "insert into CART(CART_ID,FOOD_ID,QUANTITY) values (:cartId, :foodId, :quantity)",
    nativeQuery = true)
    void addFoodToCart(Long cartId, Long foodId, Long quantity);


    @Modifying
    @Query(value = "delete from CART where CART_ID = :cartId and FOOD_ID = :foodId",
    nativeQuery = true)
    void deleteFoodFromCart(Long cartId, Long foodId);
}

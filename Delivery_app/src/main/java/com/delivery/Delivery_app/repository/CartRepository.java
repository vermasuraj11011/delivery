package com.delivery.Delivery_app.repository;

import com.delivery.Delivery_app.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

    // Inserting new food item to the cart
    @Modifying
    @Query(value = "insert into CART(CART_ID,FOOD_ID,QUANTITY) values (:cartId, :foodId, :quantity)",
    nativeQuery = true)
    void addFoodToCart(Long cartId, Long foodId, Long quantity);

    // Check if the food is already in the cart
    @Query(value = "select count (*) from CART where CART_ID = :cartId and FOOD_ID = :foodId",
    nativeQuery = true)
    int checkIfFoodInCart(Long cartId, Long foodId);

    //Updating a quantity of the food in the cart
    @Modifying
    @Query(value = "update CART set QUANTITY = :quantity where CART_ID = :cartId and FOOD_ID = :foodId",
    nativeQuery = true)
    void updateQuantity(Long cartId,Long foodId,Long quantity);

    // Deleting food item from the cart
    @Modifying
    @Query(value = "delete from CART where CART_ID = :cartId and FOOD_ID = :foodId",
    nativeQuery = true)
    void deleteFoodFromCart(Long cartId, Long foodId);

    // Geting all the list of food in a cart
    @Query(value = "select * from CART where CART_ID = :cartId",nativeQuery = true)
    List<Cart> getListOfFood(Long cartId);
}

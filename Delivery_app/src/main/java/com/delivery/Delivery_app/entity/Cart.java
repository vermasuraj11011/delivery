package com.delivery.Delivery_app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "CartID")
    private Long cartId;

    @JoinColumn(name = "FoodID")
    private Long foodId;

    @JoinColumn(name = "Quantity")
    private Long quantity;

}

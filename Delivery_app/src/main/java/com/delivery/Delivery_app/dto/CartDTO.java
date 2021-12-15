package com.delivery.Delivery_app.dto;

import lombok.*;

import javax.persistence.JoinColumn;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {

    @JoinColumn(name = "FoodID")
    private Long foodId;

    @JoinColumn(name = "Quantity")
    private Long quantity;

}

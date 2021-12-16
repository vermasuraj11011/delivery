package com.delivery.Delivery_app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @JoinColumn(name = "CartID")
    private Long cartId;

    @JoinColumn(name = "UserID")
    private Long userId;

    @JoinColumn(name = "Total_Amount")
    private Long totalAmount;

    @JoinColumn(name = "Ordered_Time")
    private Date orderedTime;

    @JoinColumn(name = "Estimated_Time")
    private Date estimatedTime;

    @JoinColumn(name = "Status")
    private String status;

}

package com.delivery.Delivery_app.entity;

import lombok.*;
import org.apache.tomcat.jni.User;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    private Long orderId;

    @OneToOne
    @JoinColumn(name = "CartID")
    private Cart cart;

//    @OneToMany
//    @JoinColumn(name = "UserID")
//    private User user;

    private Long totalAmount;

    private Date orderedTime;

    private Date estimatedTime;

    private String status;

}

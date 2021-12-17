package com.delivery.Delivery_app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "mobile_no", nullable = false,unique=true)
    private String mobileNo;

    @Column(name = "email_id", nullable = false,unique=true)
    private String emailId;

    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Address address;

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id",nullable = false, unique=true)
    private Long cartId;

    private boolean isLogin;

}
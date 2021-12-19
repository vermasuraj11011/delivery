package com.delivery.Delivery_app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Role {

    @Id
    @GeneratedValue
    private Long role_id;
    private String role;
}

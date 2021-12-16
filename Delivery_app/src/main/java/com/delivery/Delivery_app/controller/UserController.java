package com.delivery.Delivery_app.controller;

import com.delivery.Delivery_app.entity.Login;
import com.delivery.Delivery_app.entity.User;
import com.delivery.Delivery_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    register user for the first time
    @PostMapping("/register/user")
    public User addUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        return user1;
    }

//    login user
    @PostMapping("/login")
    public String login(@RequestBody Login login){
        if(userService.isLogin(login)) return "U have sucessfull Login";
        else return "Please enter valid userId or password";
    }


}
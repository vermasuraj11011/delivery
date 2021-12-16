package com.delivery.Delivery_app.service;

import com.delivery.Delivery_app.controller.AutoGenerateController;
import com.delivery.Delivery_app.entity.AutoGenerate;
import com.delivery.Delivery_app.entity.Login;
import com.delivery.Delivery_app.entity.User;
import com.delivery.Delivery_app.repository.AutoGenerateRepository;
import com.delivery.Delivery_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AutoGenerateController autoGenerateController;

    @Autowired
    PasswordEncoder passwordEncoder;



    public User addUser(User user) {
        user.setCartId(autoGenerateController.getValue());
        user.setPassword(hashing(user.getPassword()));
        User user1 = userRepository.save(user);
        return user1;
    }

    public boolean isLogin(Login login) {
        if(userRepository.findById(login.getUserId()).get().isLogin()) return true;
//        String enCodedPass = passwordEncoder.encode(login.getPassword());
        String password = hashing(login.getPassword());
        if(userRepository.checkLogin(login.getUserId(),password) != null){
            User user = userRepository.findById(login.getUserId()).get();
            user.setLogin(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public String hashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(password.getBytes());
            byte[] bytePasswordArray = messageDigest.digest();
            StringBuilder hashPassword = new StringBuilder();
            for (byte b : bytePasswordArray) {
                hashPassword.append(String.format("%02x", b));
            }
            return hashPassword.toString();
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
}

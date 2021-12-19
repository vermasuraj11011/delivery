package com.delivery.Delivery_app.service;

import com.delivery.Delivery_app.entity.User;
import com.delivery.Delivery_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        System.out.println(user);
        CustomUserDetail customUserDetail = null;

        if(user != null){
            customUserDetail = new CustomUserDetail();
            customUserDetail.setUser(user);
        }else{
            throw new UsernameNotFoundException("User not exist with name : "+userName);
        }
//        System.out.println(userRepository.fi);
        System.out.println(customUserDetail.getPassword());
        return customUserDetail;
    }
}

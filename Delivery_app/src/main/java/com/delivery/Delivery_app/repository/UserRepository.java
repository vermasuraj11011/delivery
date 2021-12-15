package com.delivery.Delivery_app.repository;

import com.delivery.Delivery_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value ="SELECT * from USER cl where cl.USER_ID=?1 AND cl.PASSWORD=?2",nativeQuery = true)
    public User checkLogin(Long USER_ID, String PASSWORD);
}

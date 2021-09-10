package com.example.loginangular.dao;

import com.example.loginangular.model.User_FrontendAngular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAngularRepository extends JpaRepository<User_FrontendAngular, Long> {
    @Query("select u from User_FrontendAngular u where u.username = ?1")
    User_FrontendAngular sqlfindUserbyId(String username);

}
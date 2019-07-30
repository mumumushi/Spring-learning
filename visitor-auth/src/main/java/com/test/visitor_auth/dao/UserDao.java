package com.test.visitor_auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.visitor_auth.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}

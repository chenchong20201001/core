package com.pingan.bill.core.dao;

import com.pingan.bill.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    public User findByUsername(String name);
}

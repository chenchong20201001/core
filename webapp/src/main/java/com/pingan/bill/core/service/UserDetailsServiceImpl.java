package com.pingan.bill.core.service;

import com.pingan.bill.core.dao.UserDao;
import com.pingan.bill.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    Logger logger= LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名为空");
        }
        System.out.println(user.getAuthorities());
        return user;
    }
}

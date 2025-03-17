package com.mi.spring.dao.impl;

import com.mi.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void update() {
        System.out.println("=================");
        System.out.println("dao update......");
        System.out.println("=================");
    }
}

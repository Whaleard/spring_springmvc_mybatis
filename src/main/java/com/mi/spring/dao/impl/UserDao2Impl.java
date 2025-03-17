package com.mi.spring.dao.impl;

import com.mi.spring.dao.UserDao2;

public class UserDao2Impl implements UserDao2 {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}

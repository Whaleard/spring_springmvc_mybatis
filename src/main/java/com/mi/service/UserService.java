package com.mi.service;

import com.mi.dao.UserDao;

public class UserService {

    // 创建对象类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("=================");
        System.out.println("service add......");
        System.out.println("=================");
        userDao.update();
    }
}

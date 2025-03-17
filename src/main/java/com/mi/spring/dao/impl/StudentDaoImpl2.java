package com.mi.spring.dao.impl;

import com.mi.spring.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl2 implements StudentDao {

    @Override
    public void add() {
        System.out.println("=================");
        System.out.println("dao add2......");
        System.out.println("=================");
    }
}

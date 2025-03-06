package com.mi.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public void add() {
        System.out.println("=================");
        System.out.println("dao add......");
        System.out.println("=================");
    }
}

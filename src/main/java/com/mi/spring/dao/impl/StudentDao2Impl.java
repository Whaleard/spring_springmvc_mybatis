package com.mi.spring.dao.impl;

import com.mi.spring.dao.StudentDao2;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao2Impl implements StudentDao2 {

    @Override
    public void sub() {
        System.out.println("=================");
        System.out.println("dao sub......");
        System.out.println("=================");
    }
}

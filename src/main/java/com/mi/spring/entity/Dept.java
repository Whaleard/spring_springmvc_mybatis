package com.mi.spring.entity;

public class Dept {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("==============================================================");
        System.out.println("dept.name：" + name);
        System.out.println("==============================================================");
    }
}

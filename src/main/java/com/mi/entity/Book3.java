package com.mi.entity;

import java.util.List;

public class Book3 {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void print() {
        System.out.println("=================");
        System.out.println(list);
        System.out.println("=================");
    }
}

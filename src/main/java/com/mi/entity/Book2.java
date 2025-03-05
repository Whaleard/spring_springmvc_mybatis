package com.mi.entity;

/**
 * p名称空间注入（本质还是通过set方法进行注入属性）
 */
public class Book2 {
    /**
     * 创建属性
     */
    private String name;

    private String author;

    /**
     * 创建属性对应的set方法
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void print() {
        System.out.println("=================");
        System.out.println("name：" + name);
        System.out.println("author：" + author);
        System.out.println("=================");
    }
}

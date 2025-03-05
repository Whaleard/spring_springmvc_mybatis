package com.mi.entity;

/**
 * 演示使用set方法进行注入属性
 */
public class Book {

    /**
     * 创建属性
     */
    private String name;

    private String author;

    private String address;

    private String content;

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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println("=================");
        System.out.println("name：" + name);
        System.out.println("author：" + author);
        System.out.println("address：" + address);
        System.out.println("content：" + content);
        System.out.println("=================");
    }
}

package com.mi.spring.entity;

/**
 * 使用有参构造注入
 */
public class Order {

    private String name;

    private String address;

    /**
     * 有参构造
     * @param name
     * @param address
     */
    public Order(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void print() {
        System.out.println("=================");
        System.out.println("name：" + name);
        System.out.println("address：" + address);
        System.out.println("=================");
    }
}

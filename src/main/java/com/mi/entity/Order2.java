package com.mi.entity;

public class Order2 {

    private String name;

    /**
     * 无参构造
     */
    public Order2() {
        System.out.println("=================");
        System.out.println("第一步，执行无参构造创建bean实例");
        System.out.println("=================");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("=================");
        System.out.println("第二步，调用set方法设置属性值");
        System.out.println("=================");
    }

    /**
     * 创建执行的初始化方法
     */
    public void initMethod() {
        System.out.println("=================");
        System.out.println("第四步，执行初始化方法");
        System.out.println("=================");
    }

    public void destroyMethod() {
        System.out.println("=================");
        System.out.println("第七步，执行销毁方法");
        System.out.println("=================");
    }
}

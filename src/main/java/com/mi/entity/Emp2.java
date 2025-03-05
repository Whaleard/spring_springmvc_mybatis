package com.mi.entity;

public class Emp2 {

    private String name;

    private String gender;

    private Dept dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void print() {
        System.out.println("=================");
        System.out.println("emp.name：" + name);
        System.out.println("gender：" + gender);
        dept.print();
        System.out.println("=================");
    }
}

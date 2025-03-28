package com.mi.spring.autowire;

public class Emp3 {

    private Dept2 dept2;

    public void setDept2(Dept2 dept2) {
        this.dept2 = dept2;
    }

    @Override
    public String toString() {
        return "Emp3{" +
                "dept2=" + dept2 +
                '}';
    }

    public void print() {
        System.out.println(dept2);
    }
}

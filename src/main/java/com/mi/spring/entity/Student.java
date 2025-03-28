package com.mi.spring.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

    /**
     * 1、数组类型属性
     */
    private String[] courses;

    /**
     * 2、List集合类型属性
     */
    private List<String> list;

    /**
     * 3、Map集合类型属性
     */
    private Map<String, String> map;

    /**
     * 4、Set集合类型属性
     */
    private Set<String> set;

    /**
     * 5、List集合类型属性（泛型为对象类型）
     */
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void print() {
        System.out.println("=================");
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList);
        System.out.println("=================");

    }
}

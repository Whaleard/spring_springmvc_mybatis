package com.mi.factorybean;

import com.mi.entity.Course;
import org.springframework.beans.factory.FactoryBean;
// todo 了解一下FactoryBean接口
public class CustomBean implements FactoryBean {

    /**
     * 定义返回bean
     * @return
     * @throws Exception
     */
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

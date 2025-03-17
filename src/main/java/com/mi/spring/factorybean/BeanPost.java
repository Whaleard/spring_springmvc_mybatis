package com.mi.spring.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
// todo 了解一下BeanPostProcessor接口
public class BeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=================");
        System.out.println("第三步，初始化之前执行的方法");
        System.out.println("=================");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=================");
        System.out.println("第五步，初始化之后执行的方法");
        System.out.println("=================");
        return bean;
    }
}

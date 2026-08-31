package com.mi.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取Spring的IOC容器（即 ApplicationContext）有多种方式，‌
 * 最推荐的是实现ApplicationContextAware接口，这是Spring官方标准做法，适用于绝大多数场景‌。
 * 实现ApplicationContextAware接口，Spring容器启动时会自动把ApplicationContext注入进来，之后就能在项目任意位置通过静态方法获取Bean了。
 * 实现ApplicationContextAware接口的类上必须加@Component等注解被Spring扫描到，否则回调不会触发，applicationContext会一直是null。‌
 *
 * @author Mr.MC
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public SpringContextHolder() {

    }

    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        checkApplicationContext();
        return applicationContext.getBean(requiredType);
    }

    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext未注入，请在applicationContext.xml中定义SpringContextHolder");
        }
    }
}

package com.mi.spring.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *  在Spring框架中，BeanPostProcessor是一个强大的扩展接口，允许开发者在Bean初始化的过程中插入自定义逻辑。
 *  它是Spring IOC容器生命周期管理的核心机制之一，广泛应用于属性注入、AOP代理、监控等场景。
 */
public class BeanPost implements BeanPostProcessor {

    /**
     * 在Bean初始化方法执行之前调用，如：@PostConstruct、InitializingBean.afterPropertiesSet()或自定义的init-method之前调用
     *
     * 典型用途：
     *  修改Bean属性（如加密字段解密）
     *  注册监听器或事件
     *  预检查（如验证必填字段）
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=================");
        System.out.println("第三步，初始化之前执行的方法");
        System.out.println("=================");
        return bean;
    }

    /**
     * 在Bean初始化方法执行完毕后调用
     *
     * 典型用途：
     *  生成动态代理（AOP的核心实现）
     *  包装Bean实例（如缓存代理）
     *  注册Bean到其他系统
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=================");
        System.out.println("第五步，初始化之后执行的方法");
        System.out.println("=================");
        return bean;
    }
}

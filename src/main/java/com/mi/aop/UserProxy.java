package com.mi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类
 *
 * @author Mr MC
 */
@Component
@Aspect // 生成代理对象
@Order(3)   // 设置多个增强类优先级
public class UserProxy {

    // 相同切入点抽取
    @Pointcut(value = "execution(* com.mi.aop.User2.add(..))")
    public void point() {

    }

    /**
     * 前置通知
     */
    @Before(value = "point()")    // @Before注解表示作为前置通知
    public void before() {
        System.out.println("=================");
        System.out.println("before......");
        System.out.println("=================");
    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "point()")
    public void afterReturning() {
        System.out.println("=================");
        System.out.println("afterReturning......");
        System.out.println("=================");
    }

    /**
     * 后置通知
     */
    @After(value = "point()")
    public void after() {
        System.out.println("=================");
        System.out.println("after......");
        System.out.println("=================");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "point()")
    public void afterThrowing() {
        System.out.println("=================");
        System.out.println("afterThrowing......");
        System.out.println("=================");
    }

    /**
     * 环绕通知
     */
    @Around(value = "point()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("=================");
        System.out.println("around before......");
        System.out.println("=================");

        // 被增强的方法执行
        point.proceed();

        System.out.println("=================");
        System.out.println("around after......");
        System.out.println("=================");
    }
}

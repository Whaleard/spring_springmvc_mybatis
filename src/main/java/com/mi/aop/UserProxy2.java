package com.mi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(6)
public class UserProxy2 {

    @Before(value = "execution(* com.mi.aop.User2.add(..))")
    public void before() {
        System.out.println("=================");
        System.out.println("before2......");
        System.out.println("=================");
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* com.mi.aop.User2.add(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("=================");
        System.out.println("around2 before......");
        System.out.println("=================");

        // 被增强的方法执行
        point.proceed();

        System.out.println("=================");
        System.out.println("around2 after......");
        System.out.println("=================");
    }
}

package com.mi.aop;

import org.springframework.stereotype.Component;

/**
 * 被增强类
 *
 * @author Mr MC
 */
@Component
public class User2 {

    public void add() {
        // int a = 10 / 0;
        System.out.println("=================");
        System.out.println("add......");
        System.out.println("=================");
    }
}

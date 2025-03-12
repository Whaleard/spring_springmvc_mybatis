package com.mi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
    @Configuration：定义配置类，代替xml配置文件
    @ComponentScan：开启注解扫描
    @EnableAspectJAutoProxy：开启AspectJ生成代理对象
 */
@Configuration
@ComponentScan(basePackages = {"com.mi"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {

}

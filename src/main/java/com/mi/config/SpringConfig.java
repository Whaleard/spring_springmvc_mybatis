package com.mi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
    @Configuration定义配置类，代替xml配置文件
    @ComponentScan开启注解扫描
 */
@Configuration
@ComponentScan(basePackages = {"com.mi"})
public class SpringConfig {

}

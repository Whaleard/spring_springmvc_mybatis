package com.mi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/requestMapping")
public class RequestMappingController {

    /*
        @RequestMapping注解
            value属性值是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求
            method属性值是一个RequestMethod类型的数组，表示该请求映射能够匹配多种请求方式的请求
                注：属性值可以为空，表示支持所有请求方式的请求
                   若当前请求的请求地址满足value属性，但是请求方式不满足method属性，浏览器报错405: Request method 'POST' not supported
            params属性值是一个字符串类型的数组，通过四种表达式设置请求参数和请求映射的匹配关系，所有表达式必须同时满足
                "param"：要求请求映射所匹配的请求必须携带param请求参数
                "!param"：要求请求映射所匹配的请求必须不携带param请求参数
                "param=value"：要求请求映射所匹配的请求必须携带param请求参数且参数值为value
                "param!=value"：要求请求映射所匹配的请求必须携带param请求参数且参数值不为value
                注：若当前请求的请求地址满足value和method属性，但是请求方式不满足params属性，浏览器报错400: Parameters conditions "xxx" not met for actual request parameters: xxx
            headers属性值是一个字符串类型的数组，通过四种表达式设置请求参数和请求映射的匹配关系，所有表达式必须同时满足
                "header"：要求请求映射所匹配的请求必须携带header请求头信息
                "!header"：要求请求映射所匹配的请求必须不携带header请求头信息
                "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且参数值为value
                "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且参数值不为value
     */
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = { RequestMethod.GET, RequestMethod.POST })
    public String testRequestMapping() {
        // 返回视图名称
        return "success";
    }

    @RequestMapping(
            value = {"/testParams"},
            method = { RequestMethod.GET, RequestMethod.POST },
            params = {"username", "password=123"})
    public String testParams() {
        // 返回视图名称
        return "success";
    }

    /*
        在restful风格中，当请求路径中含有某些数据时，就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，再通过@PathVariable注解，将占位符所表示的数据赋值给方法的形参
     */
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Long id, @PathVariable("username") String username) {
        System.out.println("id：" + id);
        System.out.println("username：" + username);
        return "success";
    }
}

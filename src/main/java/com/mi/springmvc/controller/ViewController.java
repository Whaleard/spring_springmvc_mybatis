package com.mi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    /**
     * ThymeleafViewResolver解析器
     * @return
     */
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    /**
     * SpringMVC中默认的转发视图为InternalResourceView
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}

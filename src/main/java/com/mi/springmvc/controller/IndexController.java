package com.mi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/param")
    public String param() {
        return "param";
    }
}

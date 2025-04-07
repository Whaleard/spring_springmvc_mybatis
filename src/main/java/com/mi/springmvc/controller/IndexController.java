package com.mi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // @RequestMapping("/")
    // public String toIndex() {
    //     return "index";
    // }

    @RequestMapping("/param")
    public String toParam() {
        return "param";
    }

    @RequestMapping("/view")
    public String toView() {
        return "view";
    }

    @RequestMapping("/error")
    public String toError() {
        return "error";
    }
}

package com.mi.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice将当前类标识为异常处理的组件
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * @ExceptionHandler用于设置所标识方法处理的异常
     *
     * @param e 表示当前请求处理中出现的异常
     * @param model
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception e, Model model) {
        model.addAttribute("ex", e);
        return "error";
    }
}

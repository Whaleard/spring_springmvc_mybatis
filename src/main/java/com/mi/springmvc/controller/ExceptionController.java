package com.mi.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice将当前类标识为异常处理的组件
 *
 * 异常是如何被找到的
 *  1、优先查找当前类：Spring先检查抛出异常的Controller类内部是否有@ExceptionHandler标注的方法。
 *  2、再查找全局类：如果当前Controller没有处理，Spring会扫描标注了@ControllerAdvice的类，寻找匹配的@ExceptionHandler方法。
 *  3、匹配优先级：如果存在多个@ControllerAdvice类，可以通过@Order注解控制优先级，数值越小优先级越高。
 *
 * 注：
 *  1、异常不能重复处理：不能定义两个@ExceptionHandler方法去处理同一个异常，否则初始化会失败。
 *  2、事务回滚规则：Spring默认对RuntimeException类的异常才会进行事务回滚，自定义异常建议继承该类。
 *  3、注解选择：如果希望统一返回JSON，推荐使用@RestControllerAdvice，这样方法上无需再加@ResponseBody。
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

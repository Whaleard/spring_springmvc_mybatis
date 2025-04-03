package com.mi.springmvc.controller;

import com.mi.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * 获取请求参数方式
 *
 * @author Mr.Mc
 */
@Controller
public class ParamController {

    /**
     * servlet原生api：通过HttpServletRequest获取请求参数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 参数名相同时通过getParameterValues()获取字符串数组
        // String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    /**
     * springmvc：通过控制器方法形参获取请求参数
     * @param username
     * @param password
     * @param hobby
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(@RequestParam("user_name") String username, String password, String[] hobby) {
        // 出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符串数组类型接收
        // 若使用字符串类型的形参，则多个值通过“,“进行拼接
        System.out.println("username: " + username + ", password: " + password + ", hobby: " + Arrays.toString(hobby));
        return "success";
    }

    /**
     * springmvc：通过实体类获取请求参数
     * @param user
     * @return
     */
    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }
}

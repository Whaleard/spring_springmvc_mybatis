package com.mi.springmvc.controller;

import com.mi.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 获取请求参数方式
 *
 * @author Mr.MC
 */
@Controller
public class ParamController {

    /**
     * servlet原生api：通过HttpServletRequest获取请求参数
     * @param request
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 参数名相同时通过getParameterValues()获取字符串数组
        // String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username: " + username + ", password: " + password);
        /*
            转发：服务器内部直接调用资源处理请求，包括控制器方法及页面
            重定向：服务器告诉客户端一个新的URL，客户端再发送新的请求
            区别：
                1、转发用于访问程序内的资源（WEB-INF目录下的文件或servlet方法），重定向用于访问互联网资源
                2、转发是一次请求（服务器内部进行转发请求），重定向是两次请求
                3、转发地址栏不变（服务器内部请求），重定向地址栏改变
                4、转发可以在原servlet和目标资源之间共享request请求域数据，重定向不可以
         */
        // 转发
        // request.getRequestDispatcher("/param").forward(request, response);
        // 重定向
        // response.sendRedirect("http://www.baidu.com");
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

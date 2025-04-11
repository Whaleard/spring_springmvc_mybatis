package com.mi.springmvc.controller;

import com.mi.springmvc.entity.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {

    /**
     * 通过@RequestBody注解获取请求体
     * @param requestBody
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody: " + requestBody);
        return "success";
    }

    /**
     * 通过RequestEntity实体封装请求报文
     * @param requestEntity
     * @return
     */
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    /**
     * 通过ServletAPI中的HttpServletResponse对象响应浏览器数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        // 打印输出文本格式的内容（包括html标签）到客户端
        response.getWriter().write("Hello,Response");
        response.getWriter().println();
        // 打印输出文本格式的内容（包括html标签）到客户端或将一个对象以默认的编码方式转换成二进制字节输出到客户端
        response.getWriter().print("Hello,Response");
    }

    /**
     * 通过@ResponseBody响应浏览器数据
     * @return
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        /*
            如果不添加@ResponseBody注解，则返回的字符串将作为视图名称被视图解析器解析，跳转到对应页面
            添加@ResponseBody注解，则返回的字符串将作为响应体打印输出到客户端
         */
        return "success";
    }

    /**
     * SpringMVC返回json类型
     * @return
     */
    @RequestMapping("/testResponseEntity")
    @ResponseBody
    public User testResponseEntity() {
        // @RequestBody注解会自动将返回值转换成json类型的对象或数组，如果返回值是string或者其他基本数据类型则返回字符串
        return new User(1001L, "admin", "123456", "男", 23, "123@qq.com");
    }

    /**
     * SpringMVC响应ajax请求
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println("username: " + username + ", password: " + password);
        return "Hello,Axios";
    }
}

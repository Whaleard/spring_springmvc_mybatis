package com.mi.springmvc.controller;

import com.mi.springmvc.entity.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpMessageConverter，报文信息转换器，将请求报文转换为java对象，或将java对象转换为响应报文。
 * HttpMessageConverter提供了两个注解和两个类型：@RequestBody、@ResponseBody，RequestEntity、ResponseEntity
 */
@Controller
public class HttpController {

    /**
     * 通过@RequestBody注解获取请求体
     *
     * @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，当前请求的请求体就会为当前注解所标识的形参赋值。
     *
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
     *
     * @ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
     *
     * @return
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    /**
     * SpringMVC返回json类型
     *
     * @ResponseBody处理json的步骤：
     *  1、导入jackson的依赖。
     *  2、在SpringMVC的核心配置文件中开启mvc的注解驱动，此时在HandlerAdapter中会自动装配一个消息转换器MappingJackson2HttpMessageConverter，可以将响应到浏览器的java对象转换为json格式的字符串。
     *  3、在处理器方法上使用@ResponseBody注解进行标识。
     *  4、将java对象直接作为控制器方法的返回值返回，就会自动转换为json格式的字符串。
     *
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

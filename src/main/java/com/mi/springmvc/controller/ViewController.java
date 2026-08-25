package com.mi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC中的视图是View接口，视图的作用是渲染数据，将模型Model中的数据展示给用户
 *  SpringMVC视图的种类很多，默认有转发视图InternalResourceView和重定向视图RedirectView
 *  当工程引入jstl的依赖，转发视图会自动转换成jstlView
 *  若使用的视图技术为Thymeleaf，在SpringMVC的配置文件中配置了Thymeleaf的视图解析器，由此视图解析器解析之后所得到的就是ThymeleafView
 */
@Controller
public class ViewController {

    /**
     * ThymeleafViewResolver解析器
     *  当控制器方法中所设置的视图名称没有任何前缀时，
     *  此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳转。·
     * @return
     */
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    /**
     * SpringMVC中默认的转发视图为InternalResourceView
     *  当控制器方法中所设置的视图名称以forward:为前缀时，创建InternalResourceView视图，
     *  此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀forward:去掉，剩余部分作为最终路径通过转发的方式实现跳转。
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    /**
     * SpringMVC中默认的重定向视图为RedirectView
     *  当控制器方法中所设置的视图名称以redirect:为前缀时，创建RedirectView视图，
     *  此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀redirect:去掉，剩余部分作为最终路径通过重定向的方式实现跳转。
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}

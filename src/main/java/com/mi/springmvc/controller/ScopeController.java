package com.mi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    /**
     * 使用ServletAPI向request域对象共享数据
     * @return
     */
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "Hello,ServletAPI");
        return "success";
    }

    /**
     * 使用ModelAndView向request域对象共享数据
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        // 处理模型数据，即向请求域request中共享数据
        mav.addObject("testRequestScope", "Hello,ModelAndView");
        // 设置视图名称，也就是返回的页面名称
        mav.setViewName("success");
        return mav;
    }

    /**
     * 使用Model向request域对象共享数据
     * @return
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "Hello,Model");
        return "success";
    }

    /**
     * 使用Map向request域对象共享数据
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "Hello,Map");
        return "success";
    }

    /**
     * 使用Map向request域对象共享数据
     * @return
     */
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.put("testRequestScope", "Hello,ModelMap");
        return "success";
    }

    /**
     * 使用ServletAPI向session域对象共享数据
     * @return
     */
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "Hello,Session");
        return "success";
    }

    /**
     * 使用ServletAPI向application域对象共享数据
     * @return
     */
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "Hello,Application");
        return "success";
    }
}

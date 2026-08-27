package com.mi.springmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC中的拦截器用于拦截控制器方法的执行，拦截器需要实现HandlerInterceptor或者继承HandlerInterceptorAdapter类。
 * 拦截器中有三个抽象方法：
 *  1. preHandle：控制器方法执行之前执行，其boolean类型的返回值表示是否拦截或放行，返回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法。
 *  2. postHandle：控制器方法执行之后，视图渲染之前执行。
 *  3. afterCompletion：处理完视图和模型数据，渲染视图完毕之后执行。
 * 多个拦截器的执行顺序：
 *  1. 若每个拦截器的preHandle()都返回true
 *      此时多个拦截器的执行顺序和拦截器在SpringMVC的配置文件的配置顺序有关，preHandle()会按照配置的顺序执行，而postHandle()和afterCompletion()会按照配置的反序执行。
 *  2. 若某个拦截器的preHandle()返回false
 *      preHandle()返回false和它之前的拦截器preHandle()都会执行，postHandle()都不执行，返回false的拦截器之前的拦截器的afterCompletion()会执行。
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor-->preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
        // return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor-->postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor-->afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

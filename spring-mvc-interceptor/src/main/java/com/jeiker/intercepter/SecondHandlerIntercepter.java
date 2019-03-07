package com.jeiker.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 第二个拦截器
 * User: jeikerxiao
 * Date: 2019/3/7 9:09 AM
 */
public class SecondHandlerIntercepter implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(SecondHandlerIntercepter.class);

    /**
     * 执行期：进入Handler方法之前执行
     * 应用：用于身份认证、身份授权
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // false代表拦截，不向下执行
        // true代表通过，为方便调试下一步，下面设置为true
        log.info("second Interceptor preHandle");
        return true;
    }

    /**
     * 执行期：进入Handler方法之后，返回ModelAndView之前
     * 应用：用于向ModelAndView中填充公共数据、指定统一的视图
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("second Interceptor postHandle");
    }

    /**
     * 执行期：进入Handler完成
     * 应用：用于统一异常处理、统一日志处理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("second Interceptor afterCompletion");
    }
}

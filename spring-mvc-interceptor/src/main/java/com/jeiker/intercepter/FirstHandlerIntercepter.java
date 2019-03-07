package com.jeiker.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 第一个拦截器
 * User: jeikerxiao
 * Date: 2019/3/6 9:33 PM
 */
public class FirstHandlerIntercepter implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(FirstHandlerIntercepter.class);

    /**
     * 执行期：进入Handler方法之前执行
     * 应用：用于身份认证、身份授权
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // false代表拦截，不向下执行
        // true代表通过，为方便调试下一步，下面设置为true
        log.info("first Interceptor preHandle");
        return true;
    }

    /**
     * 执行期：进入Handler方法之后，返回ModelAndView之前
     * 应用：用于向ModelAndView中填充公共数据、指定统一的视图
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("first Interceptor  postHandle");
    }

    /**
     * 执行期：进入Handler完成
     * 应用：用于统一异常处理、统一日志处理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("first Interceptor afterCompletion");
    }
}

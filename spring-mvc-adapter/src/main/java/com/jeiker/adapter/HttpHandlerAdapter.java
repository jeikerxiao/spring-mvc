package com.jeiker.adapter;

import com.jeiker.controller.HttpController;

/**
 * Description: HttpController 的适配器
 * User: jeikerxiao
 * Date: 2019/3/7 1:50 PM
 */
public class HttpHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }

    public void handle(Object handler) {
        ((HttpController) handler).doHttpHandler();
    }
}

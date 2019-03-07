package com.jeiker.adapter;

import com.jeiker.controller.SimpleController;

/**
 * Description: SimpleController的适配器
 * User: jeikerxiao
 * Date: 2019/3/7 1:49 PM
 */
public class SimpleHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }

    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }

}

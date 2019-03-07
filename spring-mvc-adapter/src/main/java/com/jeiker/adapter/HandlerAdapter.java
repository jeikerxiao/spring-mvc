package com.jeiker.adapter;

/**
 * Description: 定义一个Adapter接口
 * User: jeikerxiao
 * Date: 2019/3/7 1:45 PM
 */
public interface HandlerAdapter {

    /**
     * 是否支持
     *
     * @param handler
     * @return
     */
    boolean supports(Object handler);

    /**
     * 处理
     *
     * @param handler
     */
    void handle(Object handler);

}

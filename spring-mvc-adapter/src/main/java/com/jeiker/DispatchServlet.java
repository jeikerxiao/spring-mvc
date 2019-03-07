package com.jeiker;

import com.jeiker.adapter.AnnotationHandlerAdapter;
import com.jeiker.adapter.HandlerAdapter;
import com.jeiker.adapter.HttpHandlerAdapter;
import com.jeiker.adapter.SimpleHandlerAdapter;
import com.jeiker.controller.AnnotationController;
import com.jeiker.controller.Controller;
import com.jeiker.controller.HttpController;
import com.jeiker.controller.SimpleController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 模拟一个DispatcherServlet，适配器（适配者模式）
 * User: jeikerxiao
 * Date: 2019/3/7 1:44 PM
 */
public class DispatchServlet {

    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    /**
     * 注册所有 HandlerAdapter
     */
    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    /**
     * 模拟DispatchServlet 中的 doDispatch()方法
     */
    public void doDispatch() {

        // 此处模拟 SpringMVC 从 mappedHandler 中取 handler 的对象（Controller）
        // 不论实现何种Controller，适配器总能经过适配以后得到想要的结果
        Controller controller1 = new HttpController();
        Controller controller2 = new AnnotationController();
        Controller controller3 = new SimpleController();

        Controller handler = controller2;
        // 得到对应适配器
        HandlerAdapter handlerAdapter = getHandler(handler);
        // 通过适配器执行对应的controller对应方法
        handlerAdapter.handle(handler);
    }

    /**
     * 找到与handler适配的适配器：通过handler 遍历 HandlerAdapter 适配器来实现
     *
     * @param handler
     * @return
     */
    public HandlerAdapter getHandler(Controller handler) {
        for (HandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        return null;
    }

    /**
     * 模拟运行
     *
     * @param args
     */
    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }

}

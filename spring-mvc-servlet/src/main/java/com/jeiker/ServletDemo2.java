package com.jeiker;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Description: 使用 GenericServlet 的Demo
 * User: jeikerxiao
 * Date: 2019/3/8 2:03 PM
 */
public class ServletDemo2 extends GenericServlet {

    private final Logger logger = Logger.getLogger("ServletDemo3");

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("ServletDemo2 - service()");
        servletResponse.getWriter().write("ServletDemo2 - Hello World");
    }
}

package com.jeiker;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Description: 使用 Servlet 的Demo
 * User: jeikerxiao
 * Date: 2019/3/8 1:55 PM
 */
public class ServletDemo1 implements Servlet {

    private final Logger logger = Logger.getLogger("ServletDemo1");

    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("ServletDemo1 - init()");
    }

    public ServletConfig getServletConfig() {
        logger.info("ServletDemo1 - getServletConfig()");
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("ServletDemo1 - service()");
        servletResponse.getWriter().write("ServletDemo1 - Hello World");
    }

    public String getServletInfo() {
        logger.info("ServletDemo1 - getServletInfo()");
        return null;
    }

    public void destroy() {
        logger.info("ServletDemo1 - destroy()");

    }
}

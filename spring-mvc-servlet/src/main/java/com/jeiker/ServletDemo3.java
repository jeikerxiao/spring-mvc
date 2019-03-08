package com.jeiker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Description: 使用 HttpServlet 的Demo
 * User: jeikerxiao
 * Date: 2019/3/8 2:03 PM
 */
public class ServletDemo3 extends HttpServlet {

    private final Logger logger = Logger.getLogger("ServletDemo3");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ServletDemo3 - doGet()");
        response.getWriter().write("ServletDemo3 - Hello World");
    }

}

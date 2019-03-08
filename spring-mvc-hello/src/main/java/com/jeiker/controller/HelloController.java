package com.jeiker.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description: spring-mvc-hello
 * User: jeikerxiao
 * Date: 2019/3/8 10:04 AM
 */
@Controller
public class HelloController {

    private final Log log = LogFactory.getLog(HelloController.class);

    @RequestMapping(value = "/", method = RequestMethod.HEAD)
    public String head() {
        log.info("in head()");
        return "hello.jsp";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        log.info("in index()");
        model.addAttribute("msg", "Hello World");
        return "hello.jsp";
    }
}

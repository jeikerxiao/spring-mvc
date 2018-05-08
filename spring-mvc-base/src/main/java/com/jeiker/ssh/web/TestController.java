package com.jeiker.ssh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xiao
 * On 11/16/2017.11:59 PM
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

}

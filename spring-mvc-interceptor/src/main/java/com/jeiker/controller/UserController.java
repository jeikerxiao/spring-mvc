package com.jeiker.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Description: springmvc-read
 * User: jeikerxiao
 * Date: 2019/3/6 6:36 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/hello")
    public Map<String, String> hello() {
        log.info("hello");
        return Collections.singletonMap("message", "good");
    }
}
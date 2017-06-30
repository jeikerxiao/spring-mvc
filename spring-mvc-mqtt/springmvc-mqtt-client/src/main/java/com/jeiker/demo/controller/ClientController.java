package com.jeiker.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : xiao
 * @Date : 17/6/30 下午5:32
 */
@RestController
@RequestMapping("/mqtt")
public class ClientController {

    @GetMapping("/hello")
    public Map<String, String> sayHello(){

        Map<String, String> result = new HashMap<String, String>();
        result.put("message", "Hello World");
        return result;
    }
}

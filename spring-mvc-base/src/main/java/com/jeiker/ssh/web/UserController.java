package com.jeiker.ssh.web;

import com.jeiker.ssh.model.User;
import com.jeiker.ssh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Map<String, String> test() {
        return Collections.singletonMap("message", "test");
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }
}

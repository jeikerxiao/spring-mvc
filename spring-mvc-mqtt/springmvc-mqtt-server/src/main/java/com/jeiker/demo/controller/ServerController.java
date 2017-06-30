package com.jeiker.demo.controller;

import com.jeiker.demo.model.MessageVO;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : xiao
 * @Date : 17/6/30 下午5:32
 */
@RestController
@RequestMapping("/mqtt")
public class ServerController {

    @Resource
    private MqttPahoMessageHandler mqtt;

    @PostMapping("/send")
    public Map<String, String> sendMessage(@RequestBody MessageVO messageVO){
        Message<String> message = MessageBuilder.withPayload(messageVO.getMessage())
                .setHeader(MqttHeaders.TOPIC, "robot_server")
                .build();
        mqtt.handleMessage(message);

        Map<String, String> result = new HashMap<String, String>();
        result.put("message", "信息发送成功");
        return result;
    }

    @GetMapping("/hello")
    public Map<String, String> sayHello(){

        Map<String, String> result = new HashMap<String, String>();
        result.put("message", "Hello World");
        return result;
    }


}

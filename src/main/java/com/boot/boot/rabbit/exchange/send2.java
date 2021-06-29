/*
package com.boot.boot.rabbit.exchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class send2 {


    @Resource
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("send2")
    public void publishMessage() {

        System.out.print("=====");
        rabbitTemplate.convertAndSend("exchangeName", "", "发布消息========>");

    }
}*/

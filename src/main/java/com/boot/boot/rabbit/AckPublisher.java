/*
package com.boot.boot.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.UUID;


@Service
@RestController
public class AckPublisher implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
    @Autowired
    private RabbitTemplate ackRabbitTemplate;

    @PostConstruct
    public void init() {
        ackRabbitTemplate.setReturnCallback(this);
        ackRabbitTemplate.setConfirmCallback(this);
    }



    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("ack send succeed: " + correlationData);
            System.out.println("ack send cause: " + cause);
        } else {
            System.out.println("ack send failed: " + correlationData + "|" + cause);
        }
    }



    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("ack " + message + " 发送失败");
    }



    @RequestMapping("/publish")
    public String publish(String ans) {
        String msg = "ack msg = " + ans;
        System.out.println("发送消息publish: " + msg);

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        ackRabbitTemplate.convertAndSend("exchangeName3", "error.aa23", msg, correlationData);


        return msg;
    }

}
*/

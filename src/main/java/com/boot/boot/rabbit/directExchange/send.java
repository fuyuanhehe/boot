package com.boot.boot.rabbit.directExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class send {

    private String exchangeName = "exchangeName";

    @Resource
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("send")
    public void test() {


        CorrelationData correlationData1 = new CorrelationData(UUID.randomUUID().toString());


        rabbitTemplate.convertAndSend("exchangeName", "error", "发布到绑定routing-key是log.error的队列", correlationData1);


        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息{}接收成功", correlationData);
            } else {
                log.info("消息{}接收失败，原因{}", correlationData, cause);
            }
        });

        //发送到队列失败触发
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("消息{}发送失败，应答码{}，原因{}，交换机{}，路由键{}", message.toString(), replyCode, replyText, exchange, routingKey);
        });


    }


    @GetMapping("send2")
    public String send2() {

        rabbitTemplate.convertAndSend(exchangeName, "error", "测试会过期的", message -> {
            message.getMessageProperties().setExpiration("5000");
            return message;
        });


        return "创建订单成功";
    }


}

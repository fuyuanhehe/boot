package com.boot.boot.rabbit.directExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
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
        //  ackPublisher.publish("发布消息");

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息{}接收成功", correlationData.getId());
            } else {
                log.info("消息{}接收失败，原因{}", correlationData.getId(), cause);
            }
        });

        //发送到队列失败触发
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("消息{}发送失败，应答码{}，原因{}，交换机{}，路由键{}", message.toString(), replyCode, replyText, exchange, routingKey);
        });


        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend(exchangeName, "error", "发布到绑定routing-key是log.error的队列", correlationData);


    }


}

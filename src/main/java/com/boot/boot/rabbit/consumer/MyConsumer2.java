package com.boot.boot.rabbit.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MyConsumer2 {

    @RabbitHandler
    @RabbitListener(queues = "dlxQueueName")
    //支持自动声明绑定，声明之后自动监听队列的队列，此时@RabbitListener注解的queue和bindings不能同时指定，否则报错
 /*  @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "queueName3", durable = "true"),
            exchange = @Exchange(value = "exchangeName3"), key = "log.error")})
*/


    public void consumeMessage2(String msg, Channel channel, Message message) throws Exception {
        System.out.print("--死刑队列消费消息--------666");
        System.out.print(msg);


    }
}

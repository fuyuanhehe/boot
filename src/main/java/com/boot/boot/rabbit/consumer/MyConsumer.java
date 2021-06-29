/*
package com.boot.boot.rabbit.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

*/
/**
 * 消费者示例代码
 *
 * @author lzm
 * @date 2020/7/22 23:26
 *//*

@Component
public class MyConsumer {

    @RabbitHandler
    @RabbitListener(queues = "queueName")
    //支持自动声明绑定，声明之后自动监听队列的队列，此时@RabbitListener注解的queue和bindings不能同时指定，否则报错
*/
/*    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "queueName3", durable = "true"),
            exchange = @Exchange(value = "exchangeName3"), key = "log.error")})*//*

    public void consumeMessage(String msg, Channel channel, Message message) throws Exception {
        System.out.print("--消费消息--------1111");
        System.out.print(msg);
        throw new Exception();


        //第三个参数为true表示异常消息重新返回队列，会导致一直在刷新消息，且返回的消息处于队列头部，影响后续消息的处理
        //   channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

    }
}
*/

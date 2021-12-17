package com.boot.boot.rabbit.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消费者示例代码
 *
 * @author lzm
 * @date 2020/7/22 23:26
 */

@Component
public class MyConsumer {

    @RabbitHandler
    @RabbitListener(queues = "queueName")
    public void consumeMessage(String msg, Channel channel, Message message) throws Exception {
        System.out.print("--消费消息--------1111");
        System.out.print(msg);
        System.out.print(channel);
        System.out.print(message);


        // prefetchSize 单条消息大小限制，0代表不限制
        //prefetchCount：一次性消费的消息数量。会告诉 RabbitMQ
        // 不要同时给一个消费者推送多于 N 个消息，即一旦有 N 个消息还没有 ack，
        // 则该 consumer 将 block 掉，直到有消息 ack。
        channel.basicQos(0, 2, false);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);



        //deliveryTag:该消息的index
        //multiple：是否批量.true:将一次性拒绝所有小于deliveryTag的消息。
        //requeue：被拒绝的是否重新入队列
        //   channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);



        //channel.basicNack 与 channel.basicReject 的区别在于basicNack可以拒绝多条消息，
        // 而basicReject一次只能拒绝一条消息
        //channel.basicReject(delivery.getEnvelope().getDeliveryTag(), false);
        //
        //deliveryTag:该消息的index
        //requeue：被拒绝的是否重新入队列

    }
}


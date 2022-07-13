/*
package com.boot.boot.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SettleMqTemplate {
    @Autowired
    RabbitTemplate rabbitTemplate;


    public final RabbitTemplate.ConfirmCallback callBack = (CorrelationData correlation, boolean ack, String cause) -> {
        log.info("【mq通知发送】，【消息确认】,correlationId={},确认结果={}", correlation.getId(), ack);
        if (!ack) {
            log.error("【mq通知发送】，【消息确认】,correlationId={},确认失败，cause={}", correlation.getId(), cause);
        }
    };


    */
/**
     * 监听对不可达的消息进行后续处理;不可达消息：指定的路由key路由不到。
     *//*

    private final RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText,
                                                                  exchange, routingKey) -> {
        log.error("消息：{}找不到队列，exchange为{},routingKey为{}", message.toString(), exchange, routingKey);
    };


    public void sendMq(String exchange, String rk, Object sendData, CorrelationData correlationData) {
        rabbitTemplate.setConfirmCallback(callBack);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend(exchange,
                rk,
                sendData,
                correlationData);
    }

    */
/**
     * 延时通知mq
     *
     * @param exchange  交换机
     * @param rk        路由key
     * @param sendData  发送数据
     * @param delayTime 延迟时间
     *//*

    public void sendMqDelay(String exchange, String rk, Object sendData, CorrelationData correlationData, long delayTime) {
        rabbitTemplate.setConfirmCallback(callBack);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend(exchange,
                rk,
                sendData,
                message -> {
                    message.getMessageProperties().setExpiration(String.valueOf(delayTime));
                    return message;
                }, correlationData);
    }
}
*/

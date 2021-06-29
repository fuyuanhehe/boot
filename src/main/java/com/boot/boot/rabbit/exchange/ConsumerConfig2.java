/*
package com.boot.boot.rabbit.exchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//工作模式
@Configuration
public class ConsumerConfig2 {
    */
/**
     * 交换机名称
     *//*

    private String exchangeName = "exchangeName";

    */
/**
     * 消费者队列名称（指定队列）
     *//*

    private String queueName = "queueName";

    */
/**
     * 声明持久化队列
     *
     * @return
     *//*

    @Bean
    public Queue consumerQueue() {
        return new Queue(queueName, false);
    }

    */
/**
     * 声明扇形交换机
     *
     * @return
     *//*

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName);
    }

    */
/**
     * 声明队列和交换机的绑定
     *
     * @param consumerQueue
     * @param fanoutExchange
     * @return
     *//*

    @Bean
    public Binding binding(Queue consumerQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(consumerQueue).to(fanoutExchange);
    }
}

*/

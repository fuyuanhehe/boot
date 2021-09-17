package com.boot.boot.rabbit.dxchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死刑队列
 * @Author fuyuan
 * @Description
 * @Date 14:21 2021/9/12
 **/
@Configuration
public class dxConfig {


    @Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange("dlxExchangeName", true, false);
    }


    @Bean
    public Queue dlxQueue() {
        return new Queue("dlxQueueName", true);
    }


    @Bean
    public Binding dlcBinding(Queue dlxQueue, DirectExchange dlxExchange) {
        return BindingBuilder.bind(dlxQueue).to(dlxExchange).with("dlxRoutingKey");
    }


}

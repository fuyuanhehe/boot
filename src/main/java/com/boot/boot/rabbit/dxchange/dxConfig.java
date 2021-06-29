package com.boot.boot.rabbit.dxchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dxConfig {



    @Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange("dlxExchangeName", false, false);
    }


    @Bean
    public Queue dlxQueue() {
        return new Queue("dlxQueueName", false);
    }


    @Bean
    public Binding dlcBinding(Queue dlxQueue, DirectExchange dlxExchange) {
        return BindingBuilder.bind(dlxQueue).to(dlxExchange).with("dlxRoutingKey");
    }


}

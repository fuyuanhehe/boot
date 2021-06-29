package com.boot.boot.rabbit.directExchange;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfig3 {
    /**
     * 交换机名称
     */
    private String exchangeName = "exchangeName";

    /**
     * 主题名称
     */
    private String bindingKey = "error";

    /**
     * 消费者队列名称（指定队列）
     */
    private String queueName = "queueName";


  /*  @Bean
    public Queue consumerQueue99() {
        return new Queue(queueName, false);
    }
*/

    /**
     * 业务队列
     */
    @Bean
    public Queue consumerQueue99() {
        Map<String, Object> params = new HashMap<>();
        //声明当前队列绑定的死信交换机
        params.put("x-dead-letter-exchange", "dlxExchangeName");
        //声明当前队列的死信路由键
        params.put("x-dead-letter-routing-key", "dlxRoutingKey");

        //设置队列消息的超时时间，单位毫秒，超过时间进入死信队列
        params.put("x-message-ttl", 7000);

        //生命队列的最大长度，超过长度的消息进入死信队列
        params.put("x-max-length", 10);
        return QueueBuilder.durable(queueName).withArguments(params).build();
    }


    /**
     * 声明直连交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName, false, false);
    }
  /*  @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }*/


    /**
     * 绑定队列到直连交换机
     *
     * @param consumerQueue99 队列
     * @param directExchange  直连交换机
     * @return
     */
    @Bean
    public Binding binding(Queue consumerQueue99, DirectExchange directExchange) {
        return BindingBuilder.bind(consumerQueue99).to(directExchange).with(bindingKey);

    }
}

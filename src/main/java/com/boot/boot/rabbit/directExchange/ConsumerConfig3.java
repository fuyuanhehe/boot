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
    private static final String exchangeName = "exchangeName";

    /**
     * 主题名称
     */
    private static final String bindingKey = "error";

    /**
     * 消费者队列名称（指定队列）
     */
    private static final String queueName = "queueName";


    //durable：true、false true：在服务器重启时，能够存活
    //exclusive ：是否为当前连接的专用队列，在连接断开后，会自动删除该队列，生产环境中应该很少用到吧。
    //autodelete：当没有任何消费者使用时，自动删除该队列。this means that the queue will be deleted when there are no more processes consuming messages from it.
    //
  /*  @Bean
    public Queue consumerQueue844854() {
        return new Queue("test", false,false,false,null);
    }*/


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
        return new DirectExchange(exchangeName, true, false);
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

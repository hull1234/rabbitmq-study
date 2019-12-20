package com.mq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    // 测试队列名称
    private String testQueueName = "fanout_email_queue";
    // 测试交换机名称
    private String testExchangeName = "test_exchange";
    // RoutingKey
    private String testRoutingKey = "test_routing_key";

    /**
     * 创建队列
     */
    @Bean
    public Queue testQueue() {
        return new Queue(testQueueName);
    }

    /**
     * 创建交换机
     */
    @Bean
    public TopicExchange testExchange() {
        return new TopicExchange(testExchangeName);
    }

    /**
     * 通过routingKey把队列与交换机绑定起来
     */
    @Bean
    public Binding testBinding() {
        return BindingBuilder.bind(testQueue()).to(testExchange()).with(testRoutingKey);
    }
}

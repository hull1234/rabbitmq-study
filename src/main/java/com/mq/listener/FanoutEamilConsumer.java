//package com.mq2.mq2.mq.producer;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//public class FanoutEamilConsumer {
//    @RabbitListener(queues = "fanout_email_queue")
//    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws Exception {
//        System.out.println(Thread.currentThread().getName()
//                + ",msg:" + new String(message.getBody(), "UTF-8")
//                + ",messageId:" + message.getMessageProperties().getMessageId());
//        // 手动ack
//        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        // 手动签收
//        channel.basicAck(deliveryTag, false);
//    }
//}
package com.mq.producer;


import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Send {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queueName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "644064779");
        jsonObject.put("timestamp", System.currentTimeMillis());
        String jsonString = jsonObject.toJSONString();
        System.out.println("jsonString:" + jsonString);
        // 生产者发送消息的时候需要设置消息id
        String uuid = UUID.randomUUID() + "";
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .setMessageId(UUID.randomUUID() + "").build();
        //将messageId存入redis（在监听器判空，防止重复消费）
//        stringRedisTemplate.opsForValue().set("uuid ", uuid );
        for (int i = 0; i < 1000000000; i++) {
            rabbitTemplate.convertAndSend(queueName, message);
        }

    }

}

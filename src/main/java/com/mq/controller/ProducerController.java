package com.mq.controller;

import com.mq.producer.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private TestProducer producer;

    @RequestMapping("/sendMsg")
    public String sendFanout() {
        producer.send("test_queue");
        return "success";
    }
}
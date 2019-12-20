//package com.mq2.mq2.mq.listener;
//
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * 消费者本身异常
// */
//@Component
//public class EamilConsumer {
//    @RabbitListener(queues = "femail_queue")
//    public void process(String msg) throws Exception {
//        JSONObject jsonObject = JSONObject.parseObject(msg);
//        String email = jsonObject.getString("email");
//        String emailUrl = "http://127.0.0.1:8083/sendEmail?email=" + email;
//        JSONObject result = null;/* HttpClientUtils.httpGet(emailUrl)*/
//        if (result == null) {
//            // 因为网络原因,造成无法访问,继续重试
//            throw new Exception("调用接口失败!");
//        }
//        System.out.println("执行结束....");
//    }
//}
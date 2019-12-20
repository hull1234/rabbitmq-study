package com.mq.listener;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Process {
    @RabbitListener(queues = "fanout_email_queue")
    public void process(Message message) throws Exception {
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(msg);

//        if(!stringRedisTemplate.hasKey("meaagaeId")){
//            return;//已经被消费
//        }
        String email = jsonObject.getString("email");
        String emailUrl = "http://127.0.0.1:8083/sendEmail?email=" + email;
//        JSONObject result = HttpClientUtils.httpGet(emailUrl);
//        //如果调用第三方邮件接口无法访问，如何实现自动重试？抛出异常即可
//        if (result == null) {
//            throw new Exception("调用第三方邮件服务器接口失败!");//如果走到这一行，则会自动重试
//        }
//        stringRedisTemplate.delete(messageId);//删除，实际开发中也可以设置为空，只需要在上面判空即可
        //或者是走到这一行，写入数据库日志记录表，在上面if(StringUtils.equals。。中判断日志表中是否有记录即可
    }

}

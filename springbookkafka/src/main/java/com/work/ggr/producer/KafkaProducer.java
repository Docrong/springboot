package com.work.ggr.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.work.ggr.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author : gr
 * @date : 2019/9/17 14:30
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static Gson gson = new GsonBuilder().create();

    //发送消息方法
    public String  send() {
        Message message = new Message();
        message.setId("KFK_"+System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date().toString());
        kafkaTemplate.send("test", gson.toJson(message));
        return gson.toJson(message);
    }

}

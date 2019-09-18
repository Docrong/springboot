package com.work.ggr.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : gr
 * @date : 2019/9/17 14:31
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            System.out.println("---->"+record);
            System.out.println("---->"+message);

        }

    }
}

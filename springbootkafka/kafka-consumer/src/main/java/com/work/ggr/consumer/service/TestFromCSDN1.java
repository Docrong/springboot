package com.work.ggr.consumer.service;

import kafka.admin.AdminClient;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import scala.Option;
import scala.collection.immutable.List;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author : gr
 * @date : 2019/9/20 8:47
 * 这个方法不行,废弃
 * https://blog.csdn.net/lisi1129/article/details/72869194
 */
public class TestFromCSDN1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        AdminClient adminClient = AdminClient.create(props);
        AdminClient.ConsumerGroupSummary describeConsumerGroupsResult = adminClient.describeConsumerGroup("test-consumer-group",3000);
        if (describeConsumerGroupsResult.state().isEmpty()) {
            System.out.println("This is Null");
        }
        Option<List<AdminClient.ConsumerSummary>> consumersListOption = describeConsumerGroupsResult.consumers();
        List consumerSummarys=consumersListOption.get();
        KafkaConsumer kafkaConsumer=getNewConsumer();
        for (int i = 0; i < consumerSummarys.size(); i++) {
            AdminClient.ConsumerSummary consumerSummary = (AdminClient.ConsumerSummary) consumerSummarys.apply(i);
            String consumerId=consumerSummary.consumerId();
            String clientId=consumerSummary.clientId();

            scala.collection.immutable.Map<TopicPartition, Object> maps =
                    adminClient.listGroupOffsets("kafkatest");//或者这个组消费的所有topic，partition和当前消费到的offset
            List<TopicPartition> topicPartitions= consumerSummary.assignment();//获取这个消费者下面的所有topic和partion
            for(int j =0;j< topicPartitions.size();j++){ //循环获取每一个topic和partion
                TopicPartition topicPartition = topicPartitions.apply(j);
                String CURRENToFFSET = maps.get(topicPartition).get().toString();
                long endOffset =getLogEndOffset(topicPartition);
                System.out.println("topic的名字为："+topicPartition.topic()+"====分区为："+topicPartition.partition()+"===目前消费offset为："+CURRENToFFSET+"===,此分区最后offset为："+endOffset);
            }

        }


    }

    private static long getLogEndOffset(TopicPartition topicPartition) {

        KafkaConsumer<String, String> consumer= getNewConsumer();
        consumer.assign(Arrays.asList(topicPartition));
        consumer.seekToEnd(Arrays.asList(topicPartition));
        long endOffset = consumer.position(topicPartition);
        return endOffset;

    }

    public static KafkaConsumer getNewConsumer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "kafkatest");
        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "earliest");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer consumer = new KafkaConsumer(props);

        return consumer;
    }

}

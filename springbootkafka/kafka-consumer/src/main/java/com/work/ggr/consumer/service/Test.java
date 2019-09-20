package com.work.ggr.consumer.service;

import com.work.ggr.consumer.official_github.KafkaProperties;
import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.security.JaasUtils;
import scala.collection.JavaConversions;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

/**
 * @author : gr
 * @date : 2019/9/20 9:40
 * 这个方法显示出来的是
 */
public class Test {

    public static void main(String[] args) {
//        loglist();//废弃
        m2();
    }
    /**
    显示topics,无法显示更多内容
     */
    public static void loglist() {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.apply("localhost:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
            Map<String, Properties> configs = JavaConversions.mapAsJavaMap(AdminUtils.fetchAllTopicConfigs(zkUtils));
            // 获取特定topic的元数据
//            MetadataResponse.TopicMetadata topicMetadata = AdminUtils.fet
            // 获取特定topic的配置信息
            Properties properties = AdminUtils.fetchEntityConfig(zkUtils, "topics", "kafka-test");
            for (Map.Entry<String, Properties> entry : configs.entrySet()) {
                System.out.println("key=" + entry.getKey() + " ;value= " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zkUtils != null) {
                zkUtils.close();
            }
        }

    }

    public static void m2(){

    }

}


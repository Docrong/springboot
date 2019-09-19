package com.work.ggr.webapp.action;

import com.work.ggr.consumer.KafkaConsumer;
import com.work.ggr.producer.KafkaProducer;
import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.requests.MetadataResponse;
import org.apache.kafka.common.security.JaasUtils;
import org.apache.zookeeper.ZKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scala.collection.JavaConversions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author : gr
 * @date : 2019/9/17 14:29
 */
@RequestMapping("/kafka")
@RestController(value = "kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaConsumer consumer;

    @RequestMapping("/test")
    public String test() {
        String msg = producer.send();
        return msg;
    }

    @RequestMapping("/list")
    public String kafkaTopicList() {
        ZkUtils zkUtils = null;
        String result = "";
        try {
            String zkUrl = "localhost:2181";
            zkUtils = ZkUtils.apply(zkUrl, 30000, 30000, JaasUtils.isZkSecurityEnabled());

            List<String> topics = JavaConversions.seqAsJavaList(zkUtils.getAllTopics());
            topics.forEach(System.out::println);
            result = topics.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zkUtils != null) {
                zkUtils.close();
            }
        }
        return result;
    }

    @RequestMapping("/listTopicAllConfig")
    public void listTopicAllConfig() {
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

    public void getTopicTestMsg() {
        ZkUtils zkUtils = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }

    }

}

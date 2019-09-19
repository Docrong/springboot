package com.work.ggr.consumer.webapp.action;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scala.collection.JavaConversions;

import java.util.Map;
import java.util.Properties;

/**
 * @author : gr
 * @date : 2019/9/19 16:40
 */
@RequestMapping("/kafkaComsumer")
@RestController
public class ConsumerAction {

    @RequestMapping("/loglist")
    public void loglist(){
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
}

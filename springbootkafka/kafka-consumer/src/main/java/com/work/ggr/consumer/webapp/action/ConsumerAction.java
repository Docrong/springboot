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



}

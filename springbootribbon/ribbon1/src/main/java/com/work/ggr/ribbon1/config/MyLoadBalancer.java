package com.work.ggr.ribbon1.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/19 22:09
 */
public interface MyLoadBalancer {

    public ServiceInstance instances(List<ServiceInstance> serviceInstances);

    }
